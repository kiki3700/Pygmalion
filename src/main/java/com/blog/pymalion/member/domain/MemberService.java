package com.blog.pymalion.member.domain;


import com.blog.pymalion.member.domain.exception.NotRegisterException;
import com.blog.pymalion.member.domain.exception.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member sighUp(String email, String nickName, String password) {
        final Member member = Member.of(email, nickName, password, MemberStatus.ACTIVE);
        return memberRepository.save(member);
    }

    public Member changeStatus(UUID member_id, MemberStatus newMemberStatus) throws NotRegisterException {
        Member member = memberRepository.findById(member_id).orElseThrow(NotRegisterException::new);
        member.changeMemberStatus(newMemberStatus);
        return memberRepository.save(member);
    }

    public Member login(String email, String password) throws NotRegisterException, WrongPasswordException {
        Member member = memberRepository.findMemberByEmail(email);
        if (member == null) {
            throw new NotRegisterException();
        }
        if (!member.getPassword().equals(password)) {
            throw new WrongPasswordException();
        }
        return member;
    }


}
