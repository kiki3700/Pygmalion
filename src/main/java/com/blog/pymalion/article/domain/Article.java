package com.blog.pymalion.article;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
