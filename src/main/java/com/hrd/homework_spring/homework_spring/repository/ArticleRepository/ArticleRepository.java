package com.hrd.homework_spring.homework_spring.repository.ArticleRepository;

import com.hrd.homework_spring.homework_spring.repository.model.Article;

import java.util.List;

public interface ArticleRepository {
    void add(Article article);
    void update(Article article);
    void delete(int id);
    Article view(int id);
    List<Article> findAll();
}
