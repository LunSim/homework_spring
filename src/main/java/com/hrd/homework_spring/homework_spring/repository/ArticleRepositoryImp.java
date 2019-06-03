package com.hrd.homework_spring.homework_spring.repository;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArticleRepositoryImp implements ArticleRepository {

    @Override
    public boolean add(Article article) {
        return false;
    }

    @Override
    public Article delete(Article article) {
        return null;
    }

    @Override
    public boolean update(Article article) {
        return false;
    }

    @Override
    public Article view(int id) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }
}
