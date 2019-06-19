package com.hrd.homework_spring.homework_spring.controller;

import com.hrd.homework_spring.homework_spring.repository.ArticleRepositoryImp;
import com.hrd.homework_spring.homework_spring.repository.model.Article;
import com.hrd.homework_spring.homework_spring.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class ArticleController {
    private String images;

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String index(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer page, @RequestParam( defaultValue = "10") Integer limit) {
        System.out.println("Page : " + page + ", Limit : " + limit);
        --page;
        modelMap.addAttribute("articles", articleService.paginate(page,limit));
        modelMap.addAttribute("currentPage", ArticleRepositoryImp.currentPage + 1);
//        int lastPage = (ArticleRepositoryImp.count / limit) + (ArticleRepositoryImp.count % limit == 0 ? 0 : 1);
//        System.out.println("page is"+lastPage);
//        modelMap.addAttribute("lastPages",lastPage);
        return "/articles/index";
    }

    @GetMapping("/add")
    public String addForm(ModelMap modelMap) {
        Article article = new Article();
        article.setId(articleService.getLastId() + 1);
        modelMap.addAttribute("article", article);
        return "/articles/add";
    }

    @PostMapping("/add/ready")
    public String actionAddForm(@ModelAttribute Article article, @RequestParam MultipartFile file) {
        if (!file.isEmpty()) {
            configFileName(article, file);
            articleService.add(article);
            return "redirect:/";
        } else {
            configFileName(article, file);
            article.setImage("placeholder.png");
            articleService.add(article);

        }
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String getView(ModelMap modelMap,@PathVariable int id){
        Article article = articleService.view(id);
        if (article != null){
            modelMap.addAttribute("article", article);
        }
        return "/articles/view";
    }

    @GetMapping("/update/{id}")
    public String updateForm(ModelMap modelMap, @PathVariable int id){
        Article article = articleService.view(id);
        if (article != null){
            images = article.getImage();
            modelMap.addAttribute("article",article);
        }
        return "/articles/update";
    }
    @PostMapping("/update/ready")
    public String actionUpdate(@ModelAttribute Article article,@RequestParam MultipartFile file){
        configFileName(article,file);
        articleService.update(article);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable int id){
        articleService.delete(id);
        return "redirect:/";
    }

    private void configFileName(Article article, MultipartFile file) {
        String fileName = UUID.randomUUID().toString();
        String extension;
        if (file != null && file.getOriginalFilename() != null) {
            if (!file.getOriginalFilename().isEmpty()) {
                extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
                fileName += extension;
                try {
                    Files.copy(file.getInputStream(), Paths.get("src/main/resources/static/image/" + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                article.setImage(fileName);
                return;
            }
        }
        if(images != null) {
            article.setImage(images);
            images = null;
        }
        else
            article.setImage("placeholder.png");
    }
}
