package com.example.boardmakers.domain.posts.service;

import com.example.boardmakers.domain.posts.dto.request.PostCreateRequest;
import com.example.boardmakers.domain.posts.dto.response.PostGetDetailResponse;
import com.example.boardmakers.domain.posts.dto.response.PostGetResponse;
import com.example.boardmakers.domain.posts.entity.Post;
import com.example.boardmakers.domain.posts.repository.PostRepository;
import com.example.boardmakers.global.error.exception.ErrorCode;
import com.example.boardmakers.global.error.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
//반드시 필요한 인자를 넣어 생성자 만듬
public class PostServiceImpl implements PostService {

    private final PostRepository postingRepository;

    @Override
    @Transactional
    public Long createPost(PostCreateRequest request) {

        Post posting=Post.builder()
                .title(request.title())
                .author(request.author())
                .content(request.content())
                .isLike(false)
                .build();
        return postingRepository.save(posting).getId();
    }

    @Override
    public PostGetResponse getPost(Long id){
        Post post=postingRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorCode.ENTITY_NOT_FOUND));
        //null이 아니라면 get()해서 빼옴, null 이라면 throw
        return PostGetResponse.from(post);

    }

    @Override
    public List<PostGetResponse> getPosts(String author){
        return postingRepository
                .findByAuthor(author).stream()
                .map(PostGetResponse::from).
                toList();
    }

    @Override
    public Long getPostsNum() {
        return (long) postingRepository.findAll().size();
    }



    @Override
    public Post addLike(Long id) {
        Post posting=postingRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("해당 아이디에 등록된 게시물이 없습니다."));
        posting.setLike(true);
        postingRepository.save(posting);
        return posting;
    }



    @Override
    public Post updatePost(Long id, Post posting) {
        Post old=postingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 아이디에 등록된 게시물이 없습니다."));

        old.setCategory(posting.getCategory());
        old.setTitle(posting.getTitle());
        old.setContent(posting.getContent());
        postingRepository.save(old);
        return old;
    }

    @Override
    public void deletePost(Long id) {
        Post delete=postingRepository.
                findById((id)).orElseThrow(() -> new RuntimeException("해당 아이디에 등록된 게시물이 없습니다."));
        postingRepository.deleteById(id);
    }
}
