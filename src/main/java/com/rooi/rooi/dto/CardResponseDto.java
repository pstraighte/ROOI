package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Card;
import lombok.Getter;

@Getter
public class CardResponseDto {
    private String title;
    private String description;
    private Long columnId;


    public CardResponseDto(Card card) {
        this.title = card.getTitle();
        this.description = card.getDescription();
        this.columnId = card.getColumns().getId();
    }
}
