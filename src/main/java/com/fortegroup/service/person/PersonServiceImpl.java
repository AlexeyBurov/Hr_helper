package com.fortegroup.service.person;

import com.fortegroup.dao.people.PersonDAO;
import com.fortegroup.model.peoples.Person;
import com.fortegroup.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by alex on 5/2/17.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;


    @Transactional
    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Transactional
    @Override
    public List<Person> getAllPersonsForVacancy(String vacancy) {
        return personDAO.getAllPersonsForVacancy(vacancy);
    }

    @Transactional
    @Override
    public List<Person> getPersonsByName(String userName) {
        return personDAO.getPersonsByName(userName);
    }

    @Override
    public List<Person> getPersonsById(Long...peronsId) {
        return personDAO.getPersonsById(peronsId);
    }

    @Transactional
    @Override
    public boolean removePerson(Long id) {
        return personDAO.deletePerson(id);
    }

    @Transactional
    @Override
    public boolean addPerson(Person person, MultipartFile file,String realPath) throws IOException{
        String finalName = person.getName().
                replaceAll("\\s","")
                +System.currentTimeMillis()
                +file.getOriginalFilename()
                .substring(file.getOriginalFilename()
                        .indexOf('.'));
        Path fileWithResume = Paths.get(realPath+finalName);
        Files.write(fileWithResume,file.getBytes());
        person.setPathToResume(Constant.pathToFolder+finalName);
        return personDAO.addPerson(person);
    }

    @Transactional
    @Override
    public boolean updatePerson(Person person) {
        return personDAO.updatePerson(person);
    }

    @Override
    @Transactional
    public Person getPersonById(Long id) {
        return personDAO.getPersonById(id);
    }
}
