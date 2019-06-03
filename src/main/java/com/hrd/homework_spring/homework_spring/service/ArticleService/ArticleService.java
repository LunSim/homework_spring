package com.hrd.homework_spring.homework_spring.service.ArticleService;

import com.hrd.homework_spring.homework_spring.repository.model.Article;

import java.util.List;

public interface ArticleService {
    boolean add(Article article);
    Article delete(Article article);
    boolean update(Article article);
    Article view(int id);
    List<Article> findAll();
}
