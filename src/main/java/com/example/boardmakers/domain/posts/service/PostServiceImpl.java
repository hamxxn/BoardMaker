package com.example.boardmakers.domain.posts.service;

import com.example.boardmakers.domain.posts.dto.request.PostCreateRequest;
import com.example.boardmakers.domain.posts.dto.response.PostGetResponse;
import com.example.boardmakers.domain.posts.entity.Post;
import com.example.boardmakers.domain.posts.repository.PostRepository;
import com.example.boardmakers.global.error.exception.ErrorCode;
import com.example.boardmakers.global.error.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//반드시 필요한 인자를 넣어 생성자 만듬
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public Long createPost(PostCreateRequest request) {

        Post posting=Post.builder()
                .title(request.title())
                .author(request.author())
                .content(request.content())
                .isLike(false)
                .build();
        return postRepository.save(posting).getId();
    }

    @Override
    public PostGetResponse getPost(Long id){
        Post post=postRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        return PostGetResponse.from(post);

    }

    @Override
    public List<PostGetResponse> getPosts(String author){
        return postRepository
                .findByAuthor(author).stream()
                .map(PostGetResponse::from).
                toList();
    }

    @Override
    public Long getPostsNum() {
        return (long) postRepository.findAll().size();
    }



    @Override
    public Post addLike(Long id) {
        Post posting=postRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorCode.ENTITY_NOT_FOUND));
        posting.setLike(true);

        postRepository.save(posting);
        return posting;
    }



    @Override
    public Post updatePost(Long id, Post posting) {
        Post old=postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        old.setCategory(posting.getCategory());
        old.setTitle(posting.getTitle());
        old.setContent(posting.getContent());
        postRepository.save(old);
        return old;
    }

    @Override
    public void deletePost(Long id) {
        Post delete=postRepository.
                findById((id)).orElseThrow(() -> new NotFoundException(ErrorCode.ENTITY_NOT_FOUND));
        postRepository.deleteById(id);
    }
}
