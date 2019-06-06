package com.hrd.homework_spring.homework_spring.service;
import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import com.hrd.homework_spring.homework_spring.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void add(Article article) {
        if (article != null){
            articleRepository.add(article);
        }
    }

    @Override
    public void update(Article article) {
        if (article != null){
            articleRepository.update(article);
        }
    }

    @Override
    public void delete(int id) {
        articleRepository.delete(id);
    }

    @Override
    public Article view(int id) {
        return articleRepository.view(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
    public int getId() {
        List<Article> articles = articleRepository.findAll();
        int size = articles.size();
        if(size <= 0) {
            return 1;
        } else {
            return articles.get(size - 1).getId() + 1;
        }
    }
}
