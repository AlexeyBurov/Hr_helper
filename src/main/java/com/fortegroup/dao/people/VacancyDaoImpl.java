package com.fortegroup.dao.people;

import com.fortegroup.model.peoples.Vacancy;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by alex on 5/8/17.
 */
public class VacancyDaoImpl implements VacancyDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean addVacancy(Vacancy vacancy) {
        sessionFactory.
                getCurrentSession().
                        save(vacancy);
        return true;
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        return sessionFactory.
                getCurrentSession().
                    createCriteria(Vacancy.class).
                        list();
    }



    @Override
    public Vacancy getVacancyById(Long id) {
        return sessionFactory.
                getCurrentSession().
                    get(Vacancy.class,id);
    }

    @Override
    public List<Vacancy> getAllNotExpiredVacancies() {
        return sessionFactory.
                getCurrentSession().
                    createCriteria(Vacancy.class).
                        add(Restrictions.gt("expiredDate",new Timestamp(System.currentTimeMillis())))
                            .list();
    }

    @Override
    public boolean upVacancy(Vacancy vacancy) {
        sessionFactory.getCurrentSession().update(vacancy);
        return true;
    }
}
