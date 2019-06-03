package com.hrd.homework_spring.homework_spring.controller;

import com.hrd.homework_spring.homework_spring.repository.model.Article;
import com.hrd.homework_spring.homework_spring.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @GetMapping("/articles")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("article",articleService.findAll());
        return "/articles/index";
    }

    @GetMapping("/articles/add")
    public String addform(ModelMap modelMap){
        modelMap.addAttribute("article", new Article());
        return "/articles/add";
    }
}
