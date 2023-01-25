package com.blog.pymalion.member.application;

import com.blog.pymalion.member.domain.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {
    private final MemberService memberService;

}
