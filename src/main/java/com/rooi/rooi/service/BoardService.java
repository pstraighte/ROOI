package com.rooi.rooi.service;

import com.rooi.rooi.dto.ApiResponseDto;
import com.rooi.rooi.dto.BoardRequestDto;
import com.rooi.rooi.dto.BoardResponseDto;
import com.rooi.rooi.dto.InviteRequestDto;
import com.rooi.rooi.entity.Board;
import com.rooi.rooi.entity.Permission;
import com.rooi.rooi.entity.User;
import com.rooi.rooi.repository.BoardRepository;
import com.rooi.rooi.repository.PermissionRepository;
import com.rooi.rooi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final PermissionRepository permissionRepository;
	private final UserRepository userRepository;

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
		permissionRepository.save(new Permission(board, user));
		return new BoardResponseDto(board);
	}

	@Transactional
	public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto, User user) {
		// 존재 여부 확인
		Board board = findBoard(id);

		log.info("Service - 유저 검증");
		if (isPermission(id, user.getId())) {
			board.setTitle(requestDto.getTitle());
			board.setContents(requestDto.getContents());
			board.setBoardColor(requestDto.getBoardColor());
			log.info("Service - 유저 검증 성공");
		} else {
			log.info("Service - 유저 검증 실패");
			throw new IllegalArgumentException("작성자와 관리자만 수정할 수 있습니다.");
		}
		return new BoardResponseDto(board);
	}

	public ApiResponseDto deleteBoard(Long id, User user) {
		// 존재 여부 확인
		Board board = findBoard(id);

		log.info("Service - 유저 검증");
		if (isPermission(id, user.getId())) {
			boardRepository.delete(board);
			log.info("Service - 유저 검증 성공");
		} else {
			log.info("Service - 유저 검증 실패");
			throw new IllegalArgumentException("작성자와 관리자만 수정할 수 있습니다.");
		}
		return new ApiResponseDto("보드 삭제 완료", HttpStatus.OK.value());
	}

	public ApiResponseDto inviteUser(Long id, InviteRequestDto requestDto, User user) {
		log.info("Service - inviteUser 메서드 진입");
		Board board = findBoard(id);
		log.info("Service - findBoard 메서드 : " + board);

		log.info("Service - 작성자 확인");
		if (!(board.getUser().getId().equals(user.getId()))) {
			throw new IllegalArgumentException("작성자만 초대할 수 있습니다.");
		}

		log.info("Service - 유저 확인 전");
		User invitedUser = userRepository.findById(requestDto.getInviteUser()).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 사용자입니다.")
		);
		log.info("Service - 유저 확인 후 : " + invitedUser);

		List<Permission> permissionList = permissionRepository.findAllByBoardId(board.getId());
		log.info("Service - permissionList : " + permissionList);

		permissionRepository.save(new Permission(board, invitedUser));

		return new ApiResponseDto("초대 완료", HttpStatus.OK.value());
	}

	public Board findBoard(Long id) {
		return boardRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 보드입니다.")
		);
	}

	public boolean isPermission(Long boardId, Long userId) {
		List<Permission> boardPermissionLIst = permissionRepository.findAllByBoardId(boardId);

		for (Permission p : boardPermissionLIst) {
			if (p.getUser().getId().equals(userId)) {
				return true;
			}
		}
		return false;
	}
}