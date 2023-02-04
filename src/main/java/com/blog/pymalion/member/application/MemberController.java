package com.blog.pymalion.member.application;

import com.blog.pymalion.member.application.requestBody.SignUpRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberApplicationService memberService;

    @PostMapping("/")
    public ResponseEntity<MemberAccount> signUp(@RequestBody SignUpRequestBody signUpRequestBody) {
        String email = signUpRequestBody.getEmail();
        String nickName = signUpRequestBody.getNickName();
        String password = signUpRequestBody.getPassword();
        MemberAccount newMember = memberService.signUp(email, nickName, password);
        return ResponseEntity.ok(newMember);
    }
}
