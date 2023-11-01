package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.ICategoryService;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

//    @GetMapping
//    public ResponseEntity<Page<Blog>> getAllBlog(@RequestParam(defaultValue = "0",required = false) int page){
//        Pageable pageable = PageRequest.of(page,3);
//        Page<Blog> blogPage = blogService.blogPage(pageable);
//        if (blogPage.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogPage, HttpStatus.OK);
//    }

    @GetMapping
    public String getAllBlog(Model model){
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogList",blogList);
        return "index";
    }
}
