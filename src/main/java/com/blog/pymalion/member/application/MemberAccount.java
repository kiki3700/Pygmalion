package com.blog.pymalion.member.application;

import com.blog.pymalion.member.domain.Authority;
import com.blog.pymalion.member.domain.Member;
import com.blog.pymalion.member.domain.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberAccount {
    private UUID memberId;
    private String email;
    private String nickName;
    private String password;
    private Authority authority;
    private MemberStatus memberStatus;

    public static MemberAccount of(final Member member) {
        UUID memberId = member.getId();
        String email = member.getEmail();
        String nickName = member.getNickName();
        String password = member.getPassword();
        Authority authority = member.getAuthority();
        MemberStatus memberStatus = member.getMemberStatus();
        return new MemberAccount(memberId, email, nickName, password, authority, memberStatus);
    }

    public static MemberAccount of(UUID memberId, String email, String nickName, String password, Authority authority, MemberStatus memberStatus) {
        return new MemberAccount(memberId, email, nickName, password, authority, memberStatus);
    }

}