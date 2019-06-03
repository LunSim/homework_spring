package com.hrd.homework_spring.homework_spring.repository;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArticleRepositoryImp implements ArticleRepository {
    private List<Article> articleList;
    @Override
    public void add(Article article) {
        articleList.add(article);
    }

    @Override
    public void delete(Article article) {

    }

    @Override
    public void update(Article article) {

    }

    @Override
    public Article view(Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }
}
