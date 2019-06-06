package com.hrd.homework_spring.homework_spring.repository;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepositoryImp implements ArticleRepository {
    private List<Article> articleList;

    public ArticleRepositoryImp() {
        articleList = new ArrayList<>();
        articleList.add(new Article(1,"Love","Sim","OK","placeholder.png"));
    }

    @Override
    public void add(Article article) {
        articleList.add(article);
    }

    @Override
    public void update(Article article) {
//        for(int i = 0; i< articleList.size() ; i++ ){
//            if(articleList.get(i).getId() == article.getId()){
//                articleList.set(i,article);
//                System.out.println("has been update !");
//                return;
//            }
//        }
        for(Article article1 : articleList){
            if(article1.getId() == article.getId()){
                articleList.set(articleList.indexOf(article1), article);
                System.out.println("has been update !");
                return;
            }
        }
        System.out.println("Update Failed");
    }

    @Override
    public void delete(int id) {
        for (Article article:articleList){
            if (article.getId() == id){
                articleList.remove(article);
                return;
            }
        }
        System.out.println("Delete not successful!");
    }

    @Override
    public Article view(int id) {
        for(Article article: articleList){
            if (article.getId() == id){
                return article;
            }
        }
        return null;
    }

    @Override
    public List<Article> findAll() {
        return articleList;
    }
}
