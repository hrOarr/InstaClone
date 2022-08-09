package com.astrodust.instaclone.mapper;

import com.astrodust.instaclone.dto.RegisterDto;
import com.astrodust.instaclone.entity.Role;
import com.astrodust.instaclone.entity.User;
import com.astrodust.instaclone.enums.RoleEnum;
import com.astrodust.instaclone.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    public User dtoToEntity(RegisterDto registerDto){
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        // set roles
        Role role = roleService.findByName(RoleEnum.USER);
        if(role!=null){
            user.getRoles().add(role);
        }
        else {
            user.getRoles().add(new Role(RoleEnum.USER));
        }
        return user;
    }
}
