package com.example.blog.post.controller;

import com.example.blog.post.entity.Post;
import com.example.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/list")
        public String list(Model model) {
            List<Post> postList = postService.getList();

            model.addAttribute("postList", postList);
        return "post/list";
    }
}