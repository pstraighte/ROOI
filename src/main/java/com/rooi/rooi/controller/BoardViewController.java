package com.rooi.rooi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BoardViewController {


    @GetMapping("/board/")
    public String loginPage() {
        return "login";
    }
}
