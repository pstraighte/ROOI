package com.rooi.rooi.dto;

import com.rooi.rooi.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {
    private String content;
    private String username;

    public CommentResponseDto(Comment comment) {
        this.content = content;
        this.username = username;
    }
}
