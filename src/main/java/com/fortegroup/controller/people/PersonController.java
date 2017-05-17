package com.fortegroup.controller.people;

import com.fortegroup.model.peoples.Person;
import com.fortegroup.service.person.PersonService;
import com.fortegroup.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Rest controller, it mapping request for /rest/person/* urls
 *@author Veronika
 * @version 1.0
 */
@RestController()
@RequestMapping("/rest/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public ResponseEntity<?> addPeople(HttpServletRequest request,@RequestParam("resume") MultipartFile file){
        System.out.println(request.getServletContext().getRealPath(Constant.pathToFolder));
        Person person = getPersonFromRequest(request);
        try {
            String realPath = request.getServletContext().getRealPath("/assets/resumes/");
            boolean result = personService.addPerson(person,file,realPath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Something wrong happened");
        }
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/protected/person", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@RequestParam("id") Long id){
        return ResponseEntity.ok(personService.removePerson(id));
    }

    @RequestMapping(value = "/protected/person", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(HttpServletRequest request, @RequestParam("resume") MultipartFile file){
        Person person = getPersonFromRequest(request);
        try {
            String realPath = request.getServletContext().getRealPath("/assets/resumes/");
            boolean result = personService.addPerson(person,file,realPath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Something wrong");
        }
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/protected/allPersons",method = RequestMethod.GET)
    public ResponseEntity<?> selectAllPersons(HttpServletRequest request){
        String vacancy = request.getParameter("vacancy");
        String name = request.getParameter("name");
        if(vacancy != null && !vacancy.isEmpty()) {
            return ResponseEntity.ok(personService.getAllPersonsForVacancy(vacancy));
        }else if(name != null && !name.isEmpty()){
            return ResponseEntity.ok(personService.getPersonsByName(name));
        }else {
            return ResponseEntity.ok(personService.getAllPersons());
        }
    }


    private Person getPersonFromRequest(HttpServletRequest request){
        String fio  = request.getParameter(Constant.nameParam);
        String email = request.getParameter(Constant.emailParam);
        String telephone = request.getParameter(Constant.telephoneParam);
        String vacancy = request.getParameter(Constant.vacancyParam);
        Person person = new Person(null,fio,email,telephone,vacancy,null);
        return person;
    }

}
