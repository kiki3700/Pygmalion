package com.blog.pymalion.article.domain;

import com.blog.pymalion.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue
    private UUID commentId;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;
    private UUID memberId;
    private String text;

    private Timestamp createTime;

}
