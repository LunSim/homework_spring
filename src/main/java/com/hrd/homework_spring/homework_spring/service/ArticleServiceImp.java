package com.hrd.homework_spring.homework_spring.service;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import com.hrd.homework_spring.homework_spring.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService {

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
