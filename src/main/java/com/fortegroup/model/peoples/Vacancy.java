package com.fortegroup.model.peoples;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by alex on 5/8/17.
 */
@Entity
@Table(name = "vacancies",schema = "hr_helper")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vacancy_name")
    private String vacancyName;

    @Column(name = "expired_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;

    public Vacancy() {
    }

    public Vacancy(String vacancyName) {
        this.vacancyName = vacancyName;
        this.expiredDate = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }


}
