package com.blog.pymalion.article.application;

import com.blog.pymalion.article.domain.Category;
import com.blog.pymalion.article.domain.Comment;
import com.blog.pymalion.member.application.MemberAccount;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class ArticlePage {
    private UUID id;
    private MemberAccount memberAccount;
    private Timestamp createTime;
    private Timestamp lastModificationTime;
    private String title;
    private Category category;
    private String mainText;
    private List<Comment> comments;
    private int like;
    private int dislike;
}
