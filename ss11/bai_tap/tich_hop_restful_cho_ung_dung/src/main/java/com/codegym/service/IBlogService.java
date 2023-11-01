package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> getAllBlogId(int id);

    void create(Blog blog);
    Page<Blog> blogPage(Pageable pageable);

    List<Blog> getAllBlog();
}
