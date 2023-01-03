package com.blog.pymalion.member.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // TODO 공부해야할
public class MemberService {

    private final MemberRepository memberRepository;

    public Member sighUp(String id, String password){
        final Member member = Member.of(id, password);
        return memberRepository.save(member);

    }
}
