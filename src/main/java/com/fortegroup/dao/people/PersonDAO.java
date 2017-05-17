package com.fortegroup.dao.people;

import com.fortegroup.model.peoples.Person;

import java.util.List;

/**
 * Created by alex on 5/2/17.
 */
public interface PersonDAO {

    List<Person> getAllPersons();

    List<Person> getAllPersonsForVacancy(String vacancy);

    List<Person> getPersonsByName(String userName);

    boolean deletePerson(Long id);

    boolean addPerson(Person human);

    boolean updatePerson(Person person);

    Person getPersonById(Long id);

    List<Person> getPersonsById(Long...peronsId);
}
