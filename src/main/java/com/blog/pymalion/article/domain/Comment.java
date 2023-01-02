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

    private UUID memberId;
    private String text;

    private Timestamp createTime;

}
