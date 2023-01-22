package com.blog.pymalion.article.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
public class Category {
    private String name;
}
