package com.rooi.rooi.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CardRequestDto {
    private String title;
    private String description;
    private LocalDate deadLine;
    private String color;
    private String worker;
}