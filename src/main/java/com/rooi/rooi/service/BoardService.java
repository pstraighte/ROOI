package com.rooi.rooi.service;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.BoardRequestDto;
import com.rooi.rooi.dto.BoardResponseDto;
import com.rooi.rooi.entity.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.rooi.rooi.repository.BoardRepository;
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

	public BoardResponseDto createBoard(BoardRequestDto requestDto) {
		log.info("boardService - createBoard");
		Board board = boardRepository.save(new Board(requestDto));
		return new BoardResponseDto(board);
	}

	@Transactional
	public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto) {
		Board board = findBoard(id);

		// TODO : user 추가 후 if문으로 작성자 확인 로직 추가
		board.setTitle(requestDto.getTitle());
		board.setContents(requestDto.getContests());
		board.setBoardColor(requestDto.getBoardColor());

		return new BoardResponseDto(board);
	}

	public ApiResponseDto deleteBoard(Long id) {
		Board board = findBoard(id);

		// TODO : user 추가 후 if문으로 작성자 확인 로직 추가
		boardRepository.delete(board);

		return new ApiResponseDto("보드 삭제 완료", HttpStatus.OK.value());
	}

	public Board findBoard(Long id) {
		return boardRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 보드입니다.")
		);
	}
}