package com.fortegroup.model.complaints;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by alex on 5/9/17.
 */
@Entity
@Table(name = "complaints", schema = "hr_helper")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_email")
    private String from;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "stage")
    private String stage;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Complaint() {
    }

    public Complaint(String from, String complaint, String stage) {
        this.from = from;
        this.complaint = complaint;
        this.stage = stage;
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
