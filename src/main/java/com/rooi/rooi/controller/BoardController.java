package com.rooi.rooi.controller;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.BoardRequestDto;
import com.rooi.rooi.dto.BoardResponseDto;
import com.rooi.rooi.entity.Board;
import com.rooi.rooi.security.UserDetailsImpl;
import com.rooi.rooi.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

	private final BoardService boardService;

	// TODO : 생성자 외에 초대받은(권한이 있는) 사용자에게도 보여지게 로직 변경?
	// 내가 작성한 전체 보드 정보 가져오기
	@GetMapping
	public List<Board> getAllBoards() {
		return boardService.getAllBoards();
	}

	// 내가 작성한 특정 보드 정보 가져오기
	@GetMapping("/{id}")
	public ResponseEntity<?> getBoardById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardById(id));
	}

	@PostMapping
	public ResponseEntity<?> createBoard(@RequestBody BoardRequestDto requestDto,
	                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
		log.info("Controller - createBoard");
		BoardResponseDto result = boardService.createBoard(requestDto, userDetails.getUser());
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto,
	                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
		try {
			BoardResponseDto result = boardService.updateBoard(id, requestDto, userDetails.getUser());
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long id,
	                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
		try {
			ApiResponseDto result = boardService.deleteBoard(id, userDetails.getUser());
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
		}
	}
}