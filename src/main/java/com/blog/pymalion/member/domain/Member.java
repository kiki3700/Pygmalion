package com.blog.pymalion.member.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private UUID id;
    private String email;
    private String nickName;

    private String password;

    @Nullable
    private Authority authority;

    private MemberStatus memberStatus;

    static Member of(String email, String nickName, String password, MemberStatus memberStatus) {
        return new Member(null, email, nickName, password, null, memberStatus);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void changeMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public void changeMemberAuthority(Authority authority) {
        this.authority = authority;
    }
}
