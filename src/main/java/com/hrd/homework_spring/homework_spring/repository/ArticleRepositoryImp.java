package com.hrd.homework_spring.homework_spring.repository;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepository.ArticleRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ArticleRepositoryImp implements ArticleRepository {
    public List<Article> articleList;
    public static int count;
    public static int size;
    public static int currentPage;

    public ArticleRepositoryImp() {
        articleList = new ArrayList<>();
        for (int i =1; i <= 87 ; i++) {
            articleList.add(new Article(i,"Love","Sim","Romatic","OK","0a4c5574-6949-4a92-8cd9-43005355df76.jpg"));
        }
    }

    @Override
    public List<Article> paginate(int page, int limit) {
        currentPage = page;
        return articleList.stream().skip(page * limit).limit(limit).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void add(Article article) {
        articleList.add(article);
        return;
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
        count = articleList.size();
        return articleList;
    }

    @Override
    public int getLastId() {
        size = articleList.size();
        return (size != 0) ? articleList.get(size - 1).getId() : 1;
    }
}
