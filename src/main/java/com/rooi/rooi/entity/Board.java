package com.rooi.rooi.entity;

import com.rooi.rooi.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Timestamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(nullable = false)
	private String title;

	@Column
	private String contents;

	@Column(name = "board_color")
	private String boardColor;

	public Board(BoardRequestDto requestDto, User user) {
		this.title = requestDto.getTitle();
		this.contents = requestDto.getContents();
		this.boardColor = requestDto.getBoardColor();
		this.user = user;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setBoardColor(String boardColor) {
		this.boardColor = boardColor;
	}

	// 값을 입력하지 않는다면 default => "white"
	@PrePersist
	public void prePersist() {
		this.boardColor = this.boardColor == null ? "white" : this.boardColor;
	}
}
