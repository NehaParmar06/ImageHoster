package com.upgrad.imagehoster.controller;

import com.upgrad.imagehoster.model.Image;
import com.upgrad.imagehoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println("**** HomeController ****");
    }

    @Autowired
    private ImageService imageService;

    @RequestMapping("/")
    public String getAllImages(Model model) {
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images", images);
        return "index";
    }
}