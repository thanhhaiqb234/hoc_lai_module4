package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> getAllCategry(Pageable pageable);

    Category getCategory(int id);

    void updateCategory(Category category);

    void deleteCategory(int id);

    void createCategory(Category category);
}
