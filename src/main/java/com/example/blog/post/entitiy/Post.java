package com.example.blog.post.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    private Long Id;
}
