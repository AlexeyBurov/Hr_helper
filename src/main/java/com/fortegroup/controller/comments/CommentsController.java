package com.fortegroup.controller.comments;

import com.fortegroup.model.comments.Comment;
import com.fortegroup.service.comments.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 5/5/17.
 */
@RestController
@RequestMapping("/rest/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public ResponseEntity<?> addComment(@RequestBody Comment comment){
        return ResponseEntity.ok(commentsService.saveComment(comment) != null);
    }

    @RequestMapping(value = "/comment",method = RequestMethod.GET)
    public ResponseEntity<?> getAllComments(){
        return ResponseEntity.ok(commentsService.getAllComments());
    }

    @RequestMapping(value = "/like",method = RequestMethod.PUT)
    public ResponseEntity<?> updateLike(@RequestBody Comment comment){
        comment.setLikes(comment.getLikes() + 1);
        commentsService.updateComment(comment);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/dislike",method = RequestMethod.PUT)
    public ResponseEntity<?> updateDislike(@RequestBody Comment comment){
        comment.setDislikes(comment.getDislikes() + 1);
        commentsService.updateComment(comment);
        return ResponseEntity.ok(true);
    }
}
