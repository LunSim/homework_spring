package com.hrd.homework_spring.homework_spring.service;

import com.hrd.homework_spring.homework_spring.repository.CategoryReposity.CategoryRepository;
import com.hrd.homework_spring.homework_spring.repository.model.Category;
import com.hrd.homework_spring.homework_spring.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategoriesAll() {
        return categoryRepository.findCategoriesAll();
    }

    @Override
    public void update(Category category) {
       if (category != null){
           categoryRepository.update(category);
       }
    }

    @Override
    public Category findOne(int id) {
        return categoryRepository.findOne(id);
    }
}
