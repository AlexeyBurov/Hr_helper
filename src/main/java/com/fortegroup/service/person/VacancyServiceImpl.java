package com.fortegroup.service.person;

import com.fortegroup.dao.people.VacancyDAO;
import com.fortegroup.model.peoples.Vacancy;
import com.fortegroup.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by alex on 5/8/17.
 */
@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyDAO vacancyDAO;


    @Override
    @Transactional
    public boolean addVacancy(Vacancy vacancy) {
        vacancy.setExpiredDate(new Timestamp(System.currentTimeMillis()+ Constant.EXPIRED_ADITATION));
        return vacancyDAO.addVacancy(vacancy);
    }

    @Override
    @Transactional
    public List<Vacancy> getAllVacancies() {
        return vacancyDAO.getAllVacancies();
    }

    @Override
    @Transactional
    public Vacancy getVacancyById(Long id) {
        return vacancyDAO.getVacancyById(id);
    }

    @Override
    @Transactional
    public List<Vacancy> getAllNotExpiredVacancies() {
        return vacancyDAO.getAllNotExpiredVacancies();
    }

    @Override
    @Transactional
    public boolean upVacancy(Vacancy vacancy) {
        Vacancy daoVacancy = vacancyDAO.getVacancyById(vacancy.getId());
        daoVacancy.setExpiredDate
                (new Timestamp(System.currentTimeMillis() + Constant.EXPIRED_ADITATION));
        return vacancyDAO.upVacancy(daoVacancy);
    }
}
