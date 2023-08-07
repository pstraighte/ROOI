package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.BoardRequestDto;
import com.rooi.rooi.dto.BoardResponseDto;
import com.rooi.rooi.entity.Board;
import com.rooi.rooi.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

	private final BoardService boardService;

	@GetMapping
	public List<Board> getAllBoards() {
		return boardService.getAllBoards();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBoardById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardById(id));
	}

	@PostMapping
	public ResponseEntity<?> createBoard(@RequestBody BoardRequestDto requestDto) {
		log.info("Controller - createBoard");
		BoardResponseDto result = boardService.createBoard(requestDto);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
//		try {
		BoardResponseDto result = boardService.updateBoard(id, requestDto);
		return ResponseEntity.status(HttpStatus.OK).body(result);
//		} catch (UsernameNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
//		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
//		try {
		ApiResponseDto result = boardService.deleteBoard(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
//		} catch (UsernameNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
//		}
//	}
	}
}