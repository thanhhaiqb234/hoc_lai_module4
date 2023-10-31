package com.codegym.controller;

import com.codegym.model.Books;
import com.codegym.service.IBookService;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {


    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    public String getAllBook(Model model){
        List<Books> booksList = bookService.getAllBook();
        model.addAttribute("booksList",booksList);
        return "list";
    }
}
