package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import com.codegym.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategry(Pageable pageable) {
        Sort sort = Sort.by(Sort.Direction.ASC, "categoryName");
        int pageSize = 3;
        pageable = PageRequest.of(pageable.getPageNumber(),pageSize,sort);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void updateCategory(Category category) {
         categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
