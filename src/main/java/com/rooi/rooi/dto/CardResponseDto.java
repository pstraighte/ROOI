package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Card;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CardResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long columnId;
    private LocalDate deadLine;
    private String color;
//    private String worker;
    private List<CommentResponseDto> commentList;

    public CardResponseDto(Card card) {
        this.id = card.getId();
        this.title = card.getTitle();
        this.description = card.getDescription();
        this.columnId = card.getColumns().getId();
        this.deadLine = card.getDeadLine();
        this.color = card.getColor();
//        this.worker=card.getWorkers();
        this.commentList = card.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
