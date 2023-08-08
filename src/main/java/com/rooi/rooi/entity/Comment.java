package com.rooi.rooi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String contents, Card card, User user) {
        this.contents = contents;
        this.card = card;
        this.user = user;
    }
}
