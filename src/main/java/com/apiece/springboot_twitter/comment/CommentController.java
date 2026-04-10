package com.apiece.springboot_twitter.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/posts/{postId}/comments")
    public CommentResponse createComment(

            @PathVariable Long postId,
            @Valid @RequestBody CommentRequest request
    ){
        //댓글 생성
        return commentService.createComment(postId, request);
    }
    @GetMapping("/api/posts/{postId}/comments")
    public List<CommentResponse> getComments(@PathVariable Long postId){
        //댓글 조회
        return commentService.getComments(postId);
    }

    @PutMapping("/api/posts/{postId}/comments/{commentId}")
    public CommentResponse updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @Valid @RequestBody CommentRequest request
    ){
        return commentService.updateComment(postId, commentId, request);
    }

    @DeleteMapping("/api/posts/{postId}/comments/{commentId}")
    public  void deleteComment(
            @PathVariable Long postId,
            @PathVariable Long commentId
    ){
        //댓글 삭제
        commentService.deleteComment(postId, commentId);
    }
    @GetMapping("/api/comments")
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }
}
