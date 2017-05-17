package com.fortegroup.model.peoples;

import javax.persistence.*;

/**
 * Created by alex on 5/1/17.
 */
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "telephone", nullable = false,unique = true)
    private String telephone;

    @Column(name = "vacancy", nullable = false)
    private String vacancy;

    @Column(name = "path_to_resume")
    private String pathToResume;

    public Person(Long id, String name, String email, String telephone, String vacancy, String pathToResume) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.vacancy = vacancy;
        this.pathToResume = pathToResume;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getPathToResume() {
        return pathToResume;
    }

    public void setPathToResume(String pathToResume) {
        this.pathToResume = pathToResume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
