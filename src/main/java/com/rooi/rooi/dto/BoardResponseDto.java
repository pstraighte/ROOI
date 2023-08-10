package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
	private String title;
	private String contents;
	private String boardColor;

	public BoardResponseDto(Board board) {
		this.title = board.getTitle();
		this.contents = board.getContents();
		this.boardColor = board.getBoardColor();
	}
}
