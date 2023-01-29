package com.blog.pymalion.member.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.h2.security.SHA256;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    @Nullable
    byte[] digest;

    static Password of(String password) {
        byte[] digest = SHA256.getHash(password.getBytes(), false);
        return new Password(digest);
    }
}
