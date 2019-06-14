package com.hrd.homework_spring.homework_spring.service.ArticleService;

import com.hrd.homework_spring.homework_spring.repository.model.Article;

import java.util.List;

public interface ArticleService {
    void add(Article article);
    void update(Article article);
    void delete(int id);
    Article view(int id);
    List<Article> findAll();
    List<Article> paginate(int page, int limit);
    int getLastId();
}
