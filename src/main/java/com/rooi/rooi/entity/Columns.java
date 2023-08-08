package com.rooi.rooi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="Columns")
public class Columns {

    @Id
    @GeneratedValue
    @Column(name ="columns")
    private Long id;

    private String title;

    public Columns(Board board, String title) {
//        this.board = board;
        this.title = title;
    }

}
