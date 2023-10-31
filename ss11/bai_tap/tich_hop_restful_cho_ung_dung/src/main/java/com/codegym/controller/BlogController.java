package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.ICategoryService;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getAllBlog(@RequestParam int id){
        Optional<Blog> blogOptional = blogService.getAllBlog(id);
        if (blogOptional.isPresent()){
            return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity createBlog(@RequestBody Blog blog){
        blogService.create(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
