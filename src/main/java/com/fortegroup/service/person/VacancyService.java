package com.fortegroup.service.person;

import com.fortegroup.model.peoples.Vacancy;

import java.util.List;

/**
 * Created by alex on 5/8/17.
 */
public interface VacancyService {
    boolean addVacancy(Vacancy vacancy);
    List<Vacancy> getAllVacancies();
    Vacancy getVacancyById(Long id);
    List<Vacancy> getAllNotExpiredVacancies();
    boolean upVacancy(Vacancy vacancy);
}
