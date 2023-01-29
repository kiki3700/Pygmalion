package com.blog.pymalion.member.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
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

    @Embedded
    private Password password;

    @Nullable
    private Authority authority;

    private MemberStatus memberStatus;

    static Member of(String email, String nickName, String password, MemberStatus memberStatus) {
        return new Member(null, email, nickName, Password.of(password), null, memberStatus);
    }

    public void changePassword(String newPassword) {
        this.password = Password.of(newPassword);
    }

    public boolean isRightPassword(String password) {
        return this.password.equals(Password.of(password));
    }

    public void changeMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public void changeMemberAuthority(Authority authority) {
        this.authority = authority;
    }
}
