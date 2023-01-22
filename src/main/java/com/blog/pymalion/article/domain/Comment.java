package com.blog.pymalion.article.domain;

import com.blog.pymalion.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private UUID commentId;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;
    private UUID memberId;
    private String text;

    @CreatedDate
    private Timestamp createTime;

    public static Comment of_new_comment(Article article, UUID memberId, String text) {
        return new Comment(null, article, memberId, text, null);
    }
}
