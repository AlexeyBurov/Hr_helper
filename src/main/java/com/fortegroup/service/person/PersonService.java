package com.fortegroup.service.person;

import com.fortegroup.model.peoples.Person;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by alex on 5/2/17.
 */
public interface PersonService {

    List<Person> getAllPersons();

    List<Person> getAllPersonsForVacancy(String vacancy);

    List<Person> getPersonsByName(String userName);

    List<Person> getPersonsById(Long...peronsId);

    boolean removePerson(Long id);

    boolean addPerson(Person human, MultipartFile file,String realPath) throws IOException;

    boolean updatePerson(Person person);

    Person getPersonById(Long id);

}
