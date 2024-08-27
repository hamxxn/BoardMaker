package com.example.boardmakers.domain.posts.controller;

import com.example.boardmakers.domain.posts.dto.request.PostCreateRequest;
import com.example.boardmakers.domain.posts.dto.response.PostGetResponse;
import com.example.boardmakers.domain.posts.entity.Post;
import com.example.boardmakers.domain.posts.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private  final PostService postingService;
    public PostController(PostService postingService){
        this.postingService=postingService;
    }

    @GetMapping("/postings/{author}")
    public ResponseEntity<List<PostGetResponse>> getPosts(
            @PathVariable String author
    ){
        List<PostGetResponse> postings=postingService.getPosts(author);
        return ResponseEntity.ok(postings);
    }

    @GetMapping("/posting/num")
    public ResponseEntity<Long> getPostsNum(){
        Long num=postingService.getPostsNum();
        return ResponseEntity.ok(num);
    }
    @GetMapping("/posting/{id}")
    public ResponseEntity<PostGetResponse> getPost(
            @PathVariable("id") Long id
    ){
        PostGetResponse post=postingService.getPost(id);
        return ResponseEntity.ok(post);
    }
    @PutMapping("/posting/{id}/like")
    public  ResponseEntity<Post> addLike(
            @PathVariable("id") Long id
    ){
        Post posting=postingService.addLike(id);
        return ResponseEntity.ok(posting);
    }
    @PostMapping("/postings")
    public ResponseEntity<Long> createPost(
            @RequestBody PostCreateRequest request
    ){
        Long posting=postingService.createPost(request);
        return ResponseEntity.ok(posting);
    }
    @PutMapping("/posting/{id}")
    public ResponseEntity<Post> updatePost(
            @PathVariable("id") Long id, @RequestBody Post posting
            ){
        Post updated=postingService.updatePost(id,posting) ;
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/posting/{id}")
    public void deletePost(
            @PathVariable("id") Long id
    ){
        postingService.deletePost(id);
    }
}
