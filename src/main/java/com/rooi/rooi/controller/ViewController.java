package com.rooi.rooi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

	@GetMapping("/boards")
	public String boardsView() {
		return "boards";
	}

	@GetMapping("/boards/create")
	public String createBoardPage() {
		return "createboard";
	}

	@GetMapping("/boards/update/{id}")
	public String updateBoardPage(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		return "updateboard";
	}

	// 아직 미구현
//	@GetMapping("/boards/delete/{id}")
//	public String deleteBoardPage(@PathVariable Long id, Model model) {
//		model.addAttribute("id", id);
//		return "deleteboard";
//	}

	@GetMapping("/columns")
	public String columnsView() {
		return "columns";
	}

	@GetMapping("/cards")
	public String cardsView() {
		return "cards";
	}

	@GetMapping("/invite/{id}")
	public String inviteUserPage(@PathVariable Long id, Model model) {
		model.addAttribute("boardId", id);
		return "inviteUser";
	}
}
