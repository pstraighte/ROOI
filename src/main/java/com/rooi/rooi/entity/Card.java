package com.rooi.rooi.entity;

import com.rooi.rooi.dto.CardRequestDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@DynamicUpdate
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_id;

    @Column(name = "card_title")
    private String title;

    @Column(name = "card_description")
    private String description;

    @Column(name = "deadLine")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadLine; //포스트맨 작성식 "deadLine" : "2023-01-18"

    // 테이블을 하나 더 만들어서 관리해야 할 듯
//    @Column(name = "card_worker")
//    private String worker;

    public Card(CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.description = cardRequestDto.getDescription();
        this.deadLine = cardRequestDto.getDeadLine();
    }

    public void update(CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.description = cardRequestDto.getDescription();
    }

    // 연관관계 맵핑
}