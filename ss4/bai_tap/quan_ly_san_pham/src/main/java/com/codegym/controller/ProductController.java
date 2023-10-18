package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String getAllProduct(Model model){
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList",productList);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String getEditProduct(@PathVariable int id,
                                 Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product" , product);
        return "edit";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes){
        productService.updateProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id,
                                RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    @GetMapping("details/{id}")
    public String detailsProduct(@PathVariable int id,
                                 Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product",product);
        return "details";
    }

    @GetMapping("/form/create")
    public String formCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("create")
    public String createProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes){
        productService.createProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam(value = "name") String name,
                                Model model){
       List<Product> productList = productService.searchNameProduct(name);
       model.addAttribute("productList",productList);
        return "list";
    }
}
