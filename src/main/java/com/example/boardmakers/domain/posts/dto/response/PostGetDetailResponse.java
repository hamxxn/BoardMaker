package com.example.boardmakers.domain.posts.dto.response;

import com.example.boardmakers.domain.posts.entity.Post;
import lombok.Builder;

@Builder
public record PostGetDetailResponse(
        String category,
        String title,
        String author,
        String content,
        String created_at,
        boolean isLike
) {
    public static PostGetDetailResponse from(final Post post) {
        return PostGetDetailResponse.builder()
                .category(post.getCategory())
                .content(post.getContent())
                .title(post.getTitle())
                .author(post.getAuthor())
                .isLike(post.isLike())
                .created_at(post.getCreatedAt().toString())
                .build();
    }
}
