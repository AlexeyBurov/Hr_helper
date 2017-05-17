package com.fortegroup.dao.people;

import com.fortegroup.model.peoples.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Simple dao class for perform CRUD and other simple operation
 * with persons n our Database
 * @author Veronika
 * @version 1.0
 */
public class PersonDAOImpl implements PersonDAO {
    private final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);


    @Autowired
    private SessionFactory sessionFactory;


    /**
     * @version 1.0
     * @return {@link List< Person >} with all persons in data base
     */
    @Override
    public List<Person> getAllPersons() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> result = session.createCriteria(Person.class)
                .list();
        logger.info("List persons loaded");
        return result;
    }

    /**
     * @version 1.0
     * @param vacancy String key word for searching in DB with like
     * @return {@link List< Person >} with all persons in
     * database with like vacancy field
     */
    @Override
    public List<Person> getAllPersonsForVacancy(String vacancy) {
        Session session = sessionFactory.getCurrentSession();
        List<Person> result = session.createCriteria(Person.class).
                add(Restrictions.like("vacancy","%"+vacancy+"%"))
                .list();
        logger.info("List persons for vacancy: "+vacancy+",successfully loaded");
        return result;
    }

    /**
     *@version 1.0
     * @param personName String key word for searching in DB with like
     * @return {@link List< Person >} with all persons in
     * database with like name field
     */
    @Override
    public List<Person> getPersonsByName(String personName) {
        Session session = sessionFactory.getCurrentSession();
        List<Person> result = session.createCriteria(Person.class).
                add(Restrictions.like("name","%"+personName+"%"))
                .list();
        logger.info("List persons for name: "+personName+",successfully loaded");
        return result;
    }

    /**
     * Simple CRUD method
     * @version 1.0
     * @param id person id on DB
     * @return {@link Boolean} flag how perform operation
     */
    @Override
    public boolean deletePerson(Long id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Person people = getPersonById(id);
            session.delete(people);
            logger.info("Person for id:"+id+" successfully removed");
            return true;
        }catch (Throwable e){
            return false;
        }
    }


    /**
     * Simple CRUD method
     * @version 1.0
     * @param person Entity for save to DB
     * @return {@link Boolean} flag how perform operation
     */
    @Override
    public boolean addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
        logger.info("Person added, person info:"+person);
        return true;
    }

    /**
     * Simple CRUD method
     * @version 1.0
     * @param person Entity for update peron in DB
     * @return {@link Boolean} flag how perform operation
     */
    @Override
    public boolean updatePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated, person info:"+person);
        return true;
    }

    /**
     * Method for getting person to current id
     * @param id person id in DB
     * @return Entity {@link Person}
     */
    @Override
    public Person getPersonById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Person human = session.get(Person.class,id);
        logger.info("Person loaded, person id:"+id);
        return human;
    }

    /**
     * Method for getting {@link List< Person >}
     * @param personsId Array {@link Long} id
     * @return {@link List< Person >}
     */
    @Override
    @Transactional
    public List<Person> getPersonsById(Long... personsId) {
        Session session = sessionFactory.getCurrentSession();
        List<Person> result = session.createCriteria(Person.class)
                .add(Restrictions.in("id",personsId)).
                        list();
        return result;
    }

}
