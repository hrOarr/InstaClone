package com.astrodust.instaclone.controller;

import com.astrodust.instaclone.dto.LoginDto;
import com.astrodust.instaclone.dto.RegisterDto;
import com.astrodust.instaclone.entity.User;
import com.astrodust.instaclone.mapper.UserMapper;
import com.astrodust.instaclone.service.interfaces.SecurityService;
import com.astrodust.instaclone.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    @Qualifier("userServiceImp")
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SecurityService securityService;

    @GetMapping(value = "/login")
    public String loginForm(Model model){
        if(securityService.isAuthenticated()){
            return "redirect:/";
        }
        model.addAttribute("loginDto", new LoginDto());
        return "/auth/login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto){
        securityService.autoLogin(loginDto.getUsername(), loginDto.getPassword());
        return "redirect:/";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        if(securityService.isAuthenticated()){
            return "redirect:/";
        }
        model.addAttribute("registerDto", new RegisterDto());
        return "/auth/register";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("registerDto") RegisterDto registerDto, BindingResult result){
        logger.info("SoA:: " + registerDto.getEmail());
        User user = userMapper.dtoToEntity(registerDto);
        userService.saveOrUpdate(user);
        securityService.autoLogin(registerDto.getUsername(), registerDto.getPassword());
        return "redirect:/";
    }
}
