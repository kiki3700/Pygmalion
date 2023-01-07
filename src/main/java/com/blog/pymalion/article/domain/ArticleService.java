package com.blog.pymalion.article.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {

    final ArticleRepository articleRepository;

    public Article RegisterArticle(UUID memberID, String title, String mainText) {
        Article newArticle = Article.of_new_article(memberID, title, mainText);
        articleRepository.save(newArticle);
        return newArticle;
    }
}
