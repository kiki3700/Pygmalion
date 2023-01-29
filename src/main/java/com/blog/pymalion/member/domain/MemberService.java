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

    public Member changeStatus(UUID memberId, MemberStatus newMemberStatus) throws NotRegisterException {
        Member member = memberRepository.findById(memberId).orElseThrow(NotRegisterException::new);
        member.changeMemberStatus(newMemberStatus);
        return memberRepository.save(member);
    }

    public Member signIn(String email, String password) throws NotRegisterException, WrongPasswordException {
        Member member = memberRepository.findMemberByEmail(email);
        if (member == null) {
            throw new NotRegisterException();
        }
        if (!member.isRightPassword(password)) {
            throw new WrongPasswordException();
        }
        return member;
    }

    public Member changeAuthority(UUID memberId, Authority authority) throws NotRegisterException {
        Member member = memberRepository.findById(memberId).orElseThrow(NotRegisterException::new);
        member.changeMemberAuthority(authority);
        return memberRepository.save(member);

    }

}
