package com.rooi.rooi.controller;

import com.rooi.rooi.dto.CommentRequestDto;
import com.rooi.rooi.dto.CommentResponseDto;
import com.rooi.rooi.security.UserDetailsImpl;
import com.rooi.rooi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")   //댓글 작성
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.createComment(commentRequestDto, userDetails.getUser());
    }
    @PutMapping("/{comment_Id}")    //댓글 수정
    public CommentResponseDto updateComment(@PathVariable Long comment_Id, @RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.updateComment(comment_Id, commentRequestDto, userDetails.getUser());
    }

    @DeleteMapping("/{comment_Id}") //    삭제
    public CommentResponseDto deleteComment(@PathVariable Long comment_Id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.deleteComment(comment_Id, userDetails.getUser());
    }
}