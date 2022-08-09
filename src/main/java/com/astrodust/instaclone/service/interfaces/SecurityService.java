package com.astrodust.instaclone.service.interfaces;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}