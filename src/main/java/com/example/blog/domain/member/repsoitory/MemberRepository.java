package com.example.blog.domain.member.repsoitory;

import com.example.blog.domain.member.entity.Member;
import com.example.blog.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Post, Long> {

    Optional<Member> findByusername(String username);
}
