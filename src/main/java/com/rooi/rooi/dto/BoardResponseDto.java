package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
	private String name;
	private String contents;
	private String boardColor;

	public BoardResponseDto(Board board) {
		this.name = board.getName();
		this.contents = board.getContents();
		this.boardColor = board.getColor();
	}
}
