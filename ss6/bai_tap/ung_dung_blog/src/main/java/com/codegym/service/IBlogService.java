package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Blog getBlog(int id);

    void updateBlog(Blog blog);

    void deleteBlog(int id);

    void createBlog(Blog blog);
    Page<Blog> getAllBlog(Pageable pageable);
}
