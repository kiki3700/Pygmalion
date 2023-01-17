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

    public Article editMainText(UUID articleId, String newMainText) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.editMainText(newMainText);
        articleRepository.save(article);
        return article;
    }

    public void removeArticle(UUID articleId) {
        articleRepository.deleteById(articleId);
    }
}
