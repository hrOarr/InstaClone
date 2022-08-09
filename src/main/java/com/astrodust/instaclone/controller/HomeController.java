package com.astrodust.instaclone.controller;

import com.astrodust.instaclone.config.UserDetailsImp;
import com.astrodust.instaclone.entity.Image;
import com.astrodust.instaclone.service.interfaces.ImageService;
import com.astrodust.instaclone.service.interfaces.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ImageService imageService;

    @GetMapping(value = {"/", "/home"})
    @PreAuthorize("hasAuthority('USER')")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        List<Image> imageList = imageService.findByUserId(userDetails.getId());
        model.addAttribute("imageList", imageList);
        return "home";
    }
}
