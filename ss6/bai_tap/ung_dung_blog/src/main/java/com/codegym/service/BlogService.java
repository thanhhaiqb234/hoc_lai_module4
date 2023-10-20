package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Blog getBlog(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        Blog blog = blogRepository.findById(id).get();
        blogRepository.delete(blog);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> getAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
