package com.fortegroup.dao.people;

import com.fortegroup.model.peoples.Vacancy;

import java.util.List;

/**
 * Created by alex on 5/8/17.
 */
public interface VacancyDAO {
    boolean addVacancy(Vacancy vacancy);
    List<Vacancy> getAllVacancies();
    Vacancy getVacancyById(Long id);
    List<Vacancy> getAllNotExpiredVacancies();
    boolean upVacancy(Vacancy vacancy);
}
