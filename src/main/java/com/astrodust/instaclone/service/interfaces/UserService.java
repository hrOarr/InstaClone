package com.astrodust.instaclone.service.interfaces;

import com.astrodust.instaclone.entity.User;

public interface UserService {
    User findByUsername(String username);
    User saveOrUpdate(User user);
}
