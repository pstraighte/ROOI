package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
	private String title;
	private String contests;
	private String boardColor;

	public BoardResponseDto(Board board) {
		this.title = board.getName();
		this.contests = board.getContents();
		this.boardColor = board.getColor();
	}
}
