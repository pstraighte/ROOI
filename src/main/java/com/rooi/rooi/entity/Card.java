package com.rooi.rooi.entity;

import com.rooi.rooi.dto.CardRequestDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@DynamicUpdate
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_title")
    private String title;

    @Column(name = "card_description")
    private String description;

    // 테이블을 하나 더 만들어서 관리해야 할 듯
//    @Column(name = "card_worker")
//    private String worker;

    public Card(CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.description = cardRequestDto.getDescription();
    }

    public void update(CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.description = cardRequestDto.getDescription();
    }

    // 연관관계 맵핑
}
