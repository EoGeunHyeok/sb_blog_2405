package com.example.blog.domain.member.controller;

import com.example.blog.domain.member.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private  final MemberService memberService;
    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }
    @GetMapping("/signup")
    public String signupPage() {
        return "member/signup";
    }
    @PostMapping("/signup")
    public String signup(@Valid SignForm sinForm) {
        memberService.signup(sinForm.getUsername(), sinForm.getPassword(), sinForm.getNickname(), sinForm.email);
        return "member/signup";
    }
    @Getter
    @Setter
    @ToString
    public static class SignForm {
        @NotBlank
        @Length(min= 2)
        private String username;

        @NotBlank
        @Length(min= 4)
        private String password;

        @NotBlank
        @Length(min= 4)
        private String password_form;

        @NotBlank
        @Length(min= 4)
        private String nickname;

        @NotBlank
        @Length(min= 4)
        private String email;
    }


}
