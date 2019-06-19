package com.hrd.homework_spring.homework_spring.repository.CategoryReposity;
import com.hrd.homework_spring.homework_spring.repository.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {
    @Select("SELECT * FROM tb_categories")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Category> findCategoriesAll();

    @Update("UPDATE tb_categories SET name = #{name} WHERE id = #{id}")
    void update(Category category);

    @Select("SELECT * FROM tb_categories WHERE id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    Category findOne(int id);

    @Delete("DELETE FROM tb_categories WHERE id = #{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    void delete(int id);
}
