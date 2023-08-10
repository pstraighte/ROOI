package com.rooi.rooi.controller;

import com.rooi.rooi.dto.LoginRequestDto;
import com.rooi.rooi.dto.ProfileResponseDto;
import com.rooi.rooi.dto.SignupRequestDto;
import com.rooi.rooi.security.UserDetailsImpl;
import com.rooi.rooi.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup-page")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/api/user/signup")
    public String signup(@ModelAttribute SignupRequestDto requestDto) { //Dto -> 로 생성자 생성

        userService.signup(requestDto);

        return "redirect:/user/login-page";

    }

    // profile 조회
    @GetMapping("/user/profile")
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        ProfileResponseDto profileResponseDto = userService.getProfile(userDetails.getUser());

        // model 필요한 데이터 담아서 반환
        model.addAttribute("users", profileResponseDto);
        return "profile";
    }
//    필터에서 처리
//    @PostMapping("/user/login")
//    public String login(LoginRequestDto requestDto, HttpServletResponse res) {
//        try {
//            userService.login(requestDto, res);
//        } catch (Exception e) {
//            return "redirect:/api/user/login-page?error";
//        }
//
//        return "redirect:/";
//
//    }
}