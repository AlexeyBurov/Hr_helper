package com.fortegroup.controller.people;

import com.fortegroup.model.peoples.Vacancy;
import com.fortegroup.service.person.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alex on 5/8/17.
 */
@RestController
@RequestMapping("/rest/vacancies/")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @RequestMapping(value = "protected/vacancies",method = RequestMethod.GET)
    public ResponseEntity<?> getAllVacancies(){
        return ResponseEntity.ok(vacancyService.getAllVacancies());
    }

    @RequestMapping(value = "protected/vacancy",method = RequestMethod.POST)
    public ResponseEntity<?> addVacancy(@RequestBody Vacancy vacancy){
        return ResponseEntity.ok(vacancyService.addVacancy(vacancy));
    }

    @RequestMapping(value = "protected/vacancy",method = RequestMethod.PUT)
    public ResponseEntity<?> upVacancy(@RequestBody Vacancy vacancy){
        return ResponseEntity.ok(vacancyService.upVacancy(vacancy));
    }

    @RequestMapping(value = "allVacancies",method = RequestMethod.GET)
    public ResponseEntity<?> getNotExpiredVacancy(){
        return ResponseEntity.ok(vacancyService.getAllNotExpiredVacancies());
    }


}
