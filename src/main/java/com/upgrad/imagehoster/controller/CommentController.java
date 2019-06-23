package com.upgrad.imagehoster.controller;


import com.upgrad.imagehoster.model.Comment;
import com.upgrad.imagehoster.model.Image;
import com.upgrad.imagehoster.model.User;
import com.upgrad.imagehoster.service.CommentService;
import com.upgrad.imagehoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    public CommentController() {
        System.out.println("**** CommentController ****");
    }

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageController imageController;

    @RequestMapping(value = "/images/images", method = RequestMethod.POST)
    public String addComment(@RequestParam("tags") String tags, Image newImage, HttpSession session, Comment comment, Model model) throws IOException {

        User user = (User) session.getAttribute("loggeduser");
        comment.setUser(user);
        comment.setCreatedDate(new Date());
        comment.setImage(newImage);
        commentService.addNewComment(comment);
        //imageController.showImage(newImage.getId(), model);

        return "redirect:/images/" + newImage.getId() + "/" + newImage.getTitle() + "/comments";
    }
//
    @RequestMapping(value = "/images/images", method = RequestMethod.GET)
    public String getAllImages(@RequestParam("image") Image image, @RequestParam("user") User user) {
       List<Comment> comments = commentService.getAllComments(image);
//        commentService.getAllComments("image", image);
        return "redirect:/images/" + image.getId() + "/" + image.getTitle() + "/comments";
    }
}
