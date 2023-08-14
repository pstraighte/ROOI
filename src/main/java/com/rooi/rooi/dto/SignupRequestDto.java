package com.rooi.rooi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private String introduce;
    private boolean admin = false;
    private String adminToken = "";
}
