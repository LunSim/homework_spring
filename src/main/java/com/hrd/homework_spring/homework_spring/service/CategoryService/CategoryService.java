package com.hrd.homework_spring.homework_spring.service.CategoryService;
import com.hrd.homework_spring.homework_spring.repository.model.Category;
import java.util.List;
public interface CategoryService {
    List<Category> findCategoriesAll();
    void update(Category category);
    Category findOne(int id);
    void delete(int id);
}
