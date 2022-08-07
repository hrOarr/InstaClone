package com.astrodust.instaclone.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        logger.info("AuthenticationEntryPoint-> Unauthorized------------------->");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}