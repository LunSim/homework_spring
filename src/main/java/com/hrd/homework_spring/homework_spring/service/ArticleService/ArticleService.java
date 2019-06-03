package com.hrd.homework_spring.homework_spring.service.ArticleService;

import com.hrd.homework_spring.homework_spring.repository.model.Article;

import java.util.List;

public interface ArticleService {
    void add(Article article);
    void delete(Article article);
    void update(Article article);
    Article view(Article article);
    List<Article> findAll();
}
