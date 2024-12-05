package com.example.boardmakers.domain.posts.repository;

import com.example.boardmakers.domain.posts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    //post 또는 null 값이 들어감 -> 까서 null인지 확인==optional
    List<Post> findByAuthor(String author);
}
