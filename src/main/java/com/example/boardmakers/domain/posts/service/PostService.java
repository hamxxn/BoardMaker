package com.example.boardmakers.domain.posts.service;

import com.example.boardmakers.domain.posts.dto.request.PostCreateRequest;
import com.example.boardmakers.domain.posts.dto.response.PostGetResponse;
import com.example.boardmakers.domain.posts.entity.Post;

import java.util.List;

public interface PostService {
    List<PostGetResponse> getPosts(String author);
    Long getPostsNum();
    PostGetResponse getPost(Long id);
    Post addLike(Long id);
    Long createPost(PostCreateRequest request);
    Post updatePost(Long id, Post posting);
    void deletePost(Long id);
}
