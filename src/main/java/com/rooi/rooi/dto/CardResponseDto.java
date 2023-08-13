package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Card;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CardResponseDto {
    private String title;
    private String description;
    private Long columnId;
    private LocalDate deadLine;
    private String color;
//    private String worker;

    public CardResponseDto(Card card) {
        this.title = card.getTitle();
        this.description = card.getDescription();
        this.columnId = card.getColumns().getId();
        this.deadLine = card.getDeadLine();
        this.color = card.getColor();
//        this.worker=card.getWorkers();
    }
}
