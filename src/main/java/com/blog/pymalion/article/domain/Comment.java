package com.blog.pymalion.article.domain;

import com.blog.pymalion.member.domain.Member;

import java.sql.Timestamp;
import java.util.UUID;

public class Comment {

    private UUID commentId;

    private Member writer;
    private String text;

    private Timestamp createTime;

}
