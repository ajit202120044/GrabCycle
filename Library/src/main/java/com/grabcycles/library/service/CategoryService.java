package com.grabcycles.library.service;

import com.grabcycles.library.dto.CategoryDto;
import com.grabcycles.library.model.Category;

import java.util.List;

public interface CategoryService {
    /*Admin*/
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category update(Category category);
    void deleteById(Long id);
    void enabledById(Long id);
    List<Category> findAllByActivated();

    /*Customer*/
    List<CategoryDto> getCategoryAndProduct();


}
