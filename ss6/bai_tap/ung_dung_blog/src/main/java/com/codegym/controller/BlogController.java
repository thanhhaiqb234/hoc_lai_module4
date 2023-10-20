package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public String getAllBlog(@RequestParam(defaultValue = "0",required = false) int page,
                             Model model){
        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogPage = blogService.getAllBlog(pageable);
        model.addAttribute("blogList",blogPage);
        return "list";
    }

    @GetMapping("/details/{id}")
    public String detailsBlog(@PathVariable int id ,
                              Model model){
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog" , blog);
        return "details";
    }
    @GetMapping("/edit/{id}")
    public String getBlog(@PathVariable int id ,
                          Model model){
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog",blog);
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id){
        blogService.deleteBlog(id);
        return "redirect:/blog/list";
    }

    @GetMapping("/form/create")
    public String formCreateBlog(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.createBlog(blog);
        return "redirect:/blog/list";
    }
}
