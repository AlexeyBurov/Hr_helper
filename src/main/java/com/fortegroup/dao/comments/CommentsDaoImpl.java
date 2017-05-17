package com.fortegroup.dao.comments;

import com.fortegroup.model.comments.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alex on 5/6/17.
 */

public class CommentsDaoImpl implements CommentsDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Long saveComment(Comment comment) {
        return (Long) sessionFactory.
                getCurrentSession().
                    save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return sessionFactory.
                getCurrentSession().createCriteria(Comment.class).
                    list();
    }

    @Override
    public boolean updateComment(Comment comment) {
        sessionFactory.
                getCurrentSession().update(comment);
        return true;
    }

    @Override
    public Comment getCommentById(Long id) {
        return sessionFactory.
                getCurrentSession().
                    get(Comment.class,id);
    }
}
