package com.astrodust.instaclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/v1/test")
public class TestController {

    @GetMapping(value = "/")
    public String test(){
        return "This is testing";
    }
}
