package com.example.boardmakers.domain.posts.entity;

import com.example.boardmakers.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private  Long id;

    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String category;
    private String author;
    @Setter
    private boolean isLike;

    @Builder
    public Post(String category, String title, String author, String content, boolean isLike) {
        this.category=category;
        this.title=title;
        this.content=content;
        this.author=author;
        this.isLike=isLike;
    }
}
