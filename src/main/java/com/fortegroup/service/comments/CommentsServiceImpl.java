package com.fortegroup.service.comments;

import com.fortegroup.dao.comments.CommentsDao;
import com.fortegroup.model.comments.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Service class for operations with consumers comments
 * @implementation {@link CommentsService}
 * @author Veronika
 * @version 1.0
 */
@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsDao commentsDao;

    @Override
    @Transactional
    public Long saveComment(Comment comment) {
        comment.setDate(new Timestamp(System.currentTimeMillis()));
        comment.setLikes(0l);
        comment.setDislikes(0l);
        return commentsDao.saveComment(comment);

    }

    @Override
    @Transactional
    public List<Comment> getAllComments() {
        return commentsDao.getAllComments();
    }

    @Override
    @Transactional
    public boolean updateComment(Comment comment) {
        Comment daoComment = commentsDao.getCommentById(comment.getId());
        if (comment.getLikes() != null)
            daoComment.setLikes(comment.getLikes());
        if (comment.getDislikes() != null)
            daoComment.setDislikes(comment.getDislikes());
        return commentsDao.updateComment(daoComment);
    }
}
