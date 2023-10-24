package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String getAllCategory(Model model, Pageable pageable){
        Page<Category> categoryList = categoryService.getAllCategry(pageable);
        model.addAttribute("categoryList",categoryList);
        return "list-category";
    }

    @GetMapping("/edit/{id}")
    public String getCategory(Model model,
                              @PathVariable int id){
        Category category = categoryService.getCategory(id);
        model.addAttribute("category",category);
        return "edit-category";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category){
        categoryService.updateCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategoly(@PathVariable int id){
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }
    @GetMapping("/form/create")
    public String createCategory(Model model){
        model.addAttribute("category",new Category());
        return "create-category";
    }

    @PostMapping("create")
    public String createCategory(@ModelAttribute Category category){
        categoryService.createCategory(category);
        return "redirect:/category/list";
    }
}
