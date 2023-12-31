package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogId(int id) {
        return blogRepository.getAllBlogId(id);
    }


    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> blogPage(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }
}
