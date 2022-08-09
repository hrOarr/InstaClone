package com.astrodust.instaclone.service;

import com.astrodust.instaclone.entity.User;
import com.astrodust.instaclone.repository.UserRepository;
import com.astrodust.instaclone.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
}
