package com.rooi.rooi.entity;

import com.rooi.rooi.dto.CardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Card {

    // 컬럼
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_title")
    private String title;

    @Column(name = "card_description")
    private String description;

    @Column(name = "deadLine")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadLine; //포스트맨 작성식 "deadLine" : "2023-01-18"

    @Column(name = "card_color")
    private String color;

    // 테이블을 하나 더 만들어서 관리해야 할 듯
//    @Column(name = "card_worker")
//    private String worker;

    // 연관관계 맵핑
    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Worker> workers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="column_id")
    private Columns columns;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    // 생성자 및 메서드
    public Card(Columns columns, CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.description = cardRequestDto.getDescription();
        this.deadLine = cardRequestDto.getDeadLine();
        this.color = cardRequestDto.getColor();
//        this.workers = cardRequestDto.getWorker();
        this.columns = columns;
    }

    public void update(CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.description = cardRequestDto.getDescription();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void moveCard(Columns columns) {
        this.columns = columns;
    }
}
