package com.rooi.rooi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="Columns")
public class Columns {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="columns")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "columns",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Card> cardList = new ArrayList<>();



    public Columns(Board board, String title) {
        this.board = board;
        this.title = title;
    }

}
