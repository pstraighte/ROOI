package com.rooi.rooi.dto;

import com.rooi.rooi.entity.User;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

@Getter
public class ProfileResponseDto {
    private String username;
    private String email;
    private String introduce;


    public ProfileResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.introduce = user.getIntroduce();

    }
}