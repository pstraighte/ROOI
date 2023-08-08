package com.rooi.rooi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CardRequestDto {
    private String title;
    private String description;
    private LocalDate deadLine;
}