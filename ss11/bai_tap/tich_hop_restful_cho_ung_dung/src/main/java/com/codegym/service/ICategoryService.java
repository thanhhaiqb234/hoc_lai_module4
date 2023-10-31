package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    void createCategory(Category category);
}
