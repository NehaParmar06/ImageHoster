package com.upgrad.imagehoster.service;

import com.upgrad.imagehoster.model.Comment;
import com.upgrad.imagehoster.model.Image;
import com.upgrad.imagehoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    private List<Comment> comments = new ArrayList<>();

//    public void addNewComment(String newComment, Integer imageId, Integer userID) {
//        commentRepository.addComment(newComment);
//    }

    public void addNewComment(Comment comment) {
        commentRepository.addComment(comment);
    }

//    public List<Comment> getAllComments(Image image) {
//        return commentRepository.getComments(image.getId());
//    }

    public List<Comment> getAllComments(Image image) {
        return commentRepository.getComments(image);
    }
}
