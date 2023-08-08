package com.rooi.rooi.service;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.BoardRequestDto;
import com.rooi.rooi.dto.BoardResponseDto;
import com.rooi.rooi.entity.Board;
import com.rooi.rooi.entity.User;
import com.rooi.rooi.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	public List<Board> getAllBoards() {
		return boardRepository.findAll();
	}

	public BoardResponseDto getBoardById(Long id) {
		Board board = findBoard(id);
		return new BoardResponseDto(board);
	}

	public BoardResponseDto createBoard(BoardRequestDto requestDto, User user) {
		log.info("boardService - createBoard");
		Board board = boardRepository.save(new Board(requestDto, user));
		return new BoardResponseDto(board);
	}

	@Transactional
	public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto, User user) {
		// 존재 여부 확인
		Board board = findBoard(id);

		if (board.getUser().getId().equals(user.getId())) {
			board.setTitle(requestDto.getTitle());
			board.setContents(requestDto.getContests());
			board.setBoardColor(requestDto.getBoardColor());
		} else {
			throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
		}
		return new BoardResponseDto(board);
	}

	public ApiResponseDto deleteBoard(Long id, User user) {
		// 존재 여부 확인
		Board board = findBoard(id);

		if (board.getUser().getId().equals(user.getId())) {
			boardRepository.delete(board);
		} else {
			throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
		}
		return new ApiResponseDto("보드 삭제 완료", HttpStatus.OK.value());
	}

	public Board findBoard(Long id) {
		return boardRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 보드입니다.")
		);
	}
}