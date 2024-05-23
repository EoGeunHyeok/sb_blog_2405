package com.example.blog.post.service;

import com.example.blog.post.entity.Post;
import com.example.blog.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getList() {
        return postRepository.findAll();
    }

    public void create(String title, String content) {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();
        postRepository.save(post);
    }

}