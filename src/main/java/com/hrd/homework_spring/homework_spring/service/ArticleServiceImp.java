package com.hrd.homework_spring.homework_spring.service;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import com.hrd.homework_spring.homework_spring.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public void add(Article article) {

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
