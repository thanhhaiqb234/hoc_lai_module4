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

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list/{id}")
    public String getAllBlog(@PathVariable int id,
                             Model model,
                             Pageable pageable){
        pageable = Pageable.ofSize(2);
        Page<Blog> blogPage = blogService.getAllBlog(pageable);
        model.addAttribute("blogPage",blogPage);
        return "list-blog";
    }

    @GetMapping("/list")
    public String getAllBlog(@RequestParam(defaultValue = "0" ,required = false)int page,
                             Pageable pageable,
//                             @RequestParam(defaultValue = "",required = false)String searchName,
                             Model model){

        return "list-blog";
    }

    @GetMapping("/details/{id}")
    public String detailsBlog(@PathVariable int id ,
                              Model model){
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog" , blog);
        return "details-blog";
    }
    @GetMapping("/edit/{id}")
    public String getBlog(@PathVariable int id ,
                          Model model){
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog",blog);
        return "edit-blog";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog){
        blogService.updateBlog(blog);
        return "redirect:/blog/list/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id){
        blogService.deleteBlog(id);
        return "redirect:/blog/list{id}";
    }

    @GetMapping("/form/create")
    public String formCreateBlog(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "create-blog";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.createBlog(blog);
        return "redirect:/blog/list";
    }
}
