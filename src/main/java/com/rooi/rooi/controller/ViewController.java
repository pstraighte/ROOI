package com.rooi.rooi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/home/createboard")
    public String createBoardPage() {
        return "createboard";
    }
    @GetMapping("/boards")
    public String boardsView() {
        return "boards";
    }

    @GetMapping("/columns")
    public String columnsView() {
        return "columns";
    }
    @GetMapping("/home/createcard")
    public String createCardPage() {
        return "createcard";
    }
    @GetMapping("/cards")
    public String cardsView() {
        return "cards";
    }

    @GetMapping("/invite/{id}")
    public String inviteUserPage(@PathVariable Long id, Model model){
        model.addAttribute("boardId", id);
        return "inviteUser";
    }
}
