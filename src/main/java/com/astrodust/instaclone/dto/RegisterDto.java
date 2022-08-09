package com.astrodust.instaclone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDto {
    private String username;
    private String email;
    private String password;
}