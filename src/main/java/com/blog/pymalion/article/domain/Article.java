package com.blog.pymalion.article.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @Column(name = "ARTICLE_ID")
    @GeneratedValue
    private UUID id;

    private UUID member_id;

    @CreatedDate
    private Timestamp createTime;

    @LastModifiedDate
    private Timestamp lastModifiedTime;

    private String title;

    @Embedded
    private Category category;

    private String mainText;

    public static Article of_new_article(UUID memberId, String title, Category category, String mainText) {
        return new Article(null, memberId, null, null, title, category, mainText);
    }

    public Article editMainText(String newMainText) {
        this.mainText = newMainText;
        return this;
    }
}
