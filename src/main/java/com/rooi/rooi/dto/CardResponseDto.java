package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CardResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long columnId;
    private LocalDate deadLine;
    private String color;
    private List<WorkerResponseDto> workerList;
    private List<CommentResponseDto> commentList;

    public CardResponseDto(Card card) {
        this.id = card.getId();
        this.title = card.getTitle();
        this.description = card.getDescription();
        this.columnId = card.getColumns().getId();
        this.deadLine = card.getDeadLine();
        this.color = card.getColor();
        this.workerList = card.getWorkers().stream().map(WorkerResponseDto::new).collect(Collectors.toList());
        this.commentList = card.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
