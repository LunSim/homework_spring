package com.hrd.homework_spring.homework_spring.controller;
import com.hrd.homework_spring.homework_spring.repository.model.Category;
import com.hrd.homework_spring.homework_spring.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String showAllCategories(ModelMap map){
        System.out.println(categoryService.findCategoriesAll());
        map.addAttribute("categories",categoryService.findCategoriesAll());
        return "/categories/index";
    }

    @GetMapping("/category/update/{id}")
    public String updateForm(ModelMap modelMap, @PathVariable int id){
        Category category = categoryService.findOne(id);
        if (category != null){
            modelMap.addAttribute("category",categoryService.findOne(id));
        }
        return "/categories/update";
    }
    @PostMapping("/category/update")
    public String actionUpdate(@ModelAttribute Category category){
        categoryService.update(category);
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.delete(id);
        return "redirect:/category";
    }

}
