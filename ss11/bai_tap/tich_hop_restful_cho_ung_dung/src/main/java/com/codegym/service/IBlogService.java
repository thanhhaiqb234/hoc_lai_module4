package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    Optional<Blog> getBlog(int id);

    List<Blog> getAllBlogId(int id);

    List<Blog> getAllBlog();

    void create(Blog blog);
}
