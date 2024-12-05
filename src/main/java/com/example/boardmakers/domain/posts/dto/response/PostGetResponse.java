package com.example.boardmakers.domain.posts.dto.response;

import com.example.boardmakers.domain.posts.entity.Post;
import lombok.Builder;

@Builder
public record PostGetResponse(
        String category,
        String title,
        String content
) {
    public static PostGetResponse from(final Post post) {
        System.out.println("Transforming Post to PostGetDetailResponse: " + post);
        return PostGetResponse.builder()
                .category(post.getCategory())
                .content(post.getContent())
                .title(post.getTitle())
                .build();
    }
}
