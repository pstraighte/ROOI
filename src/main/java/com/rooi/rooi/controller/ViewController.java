package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ProfileResponseDto;
import com.rooi.rooi.security.UserDetailsImpl;
import com.rooi.rooi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ViewController {

//    private final UserService userService;
//
//    public ViewController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // profile 조회
//    @GetMapping("/user/profile")
//    public String getProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
//        ProfileResponseDto profileResponseDto = userService.getProfile(userDetails.getUser());
//
//        // model 필요한 데이터 담아서 반환
//        model.addAttribute("users", profileResponseDto);
//        return "profile";
//    }

//    @GetMapping("/api/profile")
//    public String getProfile() {
//        return "mypageupdate";
//    }
//
//    @GetMapping("/api/profile/password")
//    public String confirmPassword(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return "password";
//    }
//
//    @GetMapping("/api/profile/passwordupdate")
//    public String getPassword(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return "passwordupdate";
//    }
}