package com.blog.pymalion.member.application.requestBody;

import lombok.Getter;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;

@Getter
public class SignUpRequestBody {
    private String email;
    private String nickName;
    private String password;

}
