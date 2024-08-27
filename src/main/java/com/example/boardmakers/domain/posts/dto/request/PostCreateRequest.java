package com.example.boardmakers.domain.posts.dto.request;

public record PostCreateRequest(
        String category,
        String title,
        String author,
        String content
) {
}
