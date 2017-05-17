package com.fortegroup.model.comments;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alex on 5/5/17.
 */
@Entity
@Table(name = "comments",schema = "hr_helper")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_email")
    private String from;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;


    @Column(name = "dislikes")
    private Long dislikes;

    @Column(name = "likes")
    private Long likes;

    public Comment() {
    }

    public Comment(String from, String comment, Date date, Long dislikes, Long likes) {
        this.from = from;
        this.comment = comment;
        this.date = date;
        this.dislikes = dislikes;
        this.likes = likes;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }
}