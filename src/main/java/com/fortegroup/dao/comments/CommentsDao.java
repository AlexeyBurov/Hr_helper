package com.fortegroup.dao.comments;

import com.fortegroup.model.comments.Comment;

import java.util.List;

/**
 * Created by alex on 5/6/17.
 */
public interface CommentsDao {

    Long saveComment(Comment comment);
    List<Comment> getAllComments();

    boolean updateComment(Comment comment);

    Comment getCommentById(Long id);
}
