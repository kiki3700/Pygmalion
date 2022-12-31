package com.blog.pymalion.article.domain;

import com.blog.pymalion.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class Article {
    private UUID id;

    private Member writer;

    private Category tag;

    private Timestamp createTime;

    private Timestamp lastModifiedTime;

    private String title;

    private String mainText;

    private Comment comment;


}
