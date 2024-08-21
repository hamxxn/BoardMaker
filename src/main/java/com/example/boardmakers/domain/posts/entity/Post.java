package com.example.boardmakers.domain.posts.entity;

import com.example.boardmakers.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private  Long id;

    private String title;
    private String content;
    private String category;
    private String author;

    private boolean isLike;

    @Builder
    public Post(String category, String title, String author, String content, boolean isLike) {

        this.category=category;
        this.title=title;
        this.content=content;
        this.author=author;
        this.isLike=isLike;

    }

    public void setLike(boolean like){
        this.isLike=isLike;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setContent(String content){
        this.content=content;
    }

}
