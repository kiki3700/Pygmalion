package com.blog.pymalion.member.application;

import com.blog.pymalion.member.domain.Authority;
import com.blog.pymalion.member.domain.Member;
import com.blog.pymalion.member.domain.MemberService;
import com.blog.pymalion.member.domain.exception.NotRegisterException;
import com.blog.pymalion.member.domain.exception.WrongPasswordException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {

    private final MemberService memberService;

    @Transactional
    public MemberAccount signUp(String email, String nickName, String password, Authority authority) {
        Member newMember = memberService.sighUp(email, nickName, password);
        return MemberAccount.of(newMember);
    }

    @Transactional
    public MemberAccount signIn(String email, String password) throws NotRegisterException, WrongPasswordException {
        Member member = memberService.signIn(email, password);
        return MemberAccount.of(member);
    }

}
