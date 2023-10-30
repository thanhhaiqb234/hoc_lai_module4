package com.codegym.controller;

import com.codegym.model.Books;
import com.codegym.model.Orders;
import com.codegym.service.IBookService;
import com.codegym.service.IOrderService;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Max;
import java.util.Random;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBookService bookService;
    @GetMapping("/form/{id}")
    public String getLiaat(@PathVariable int id ,
                           Model model){

        Books books = bookService.finById(id);
        
        Orders orders = new Orders();
        String code = "";
        for (int i = 0; i < 5; i++) {
            int number = (int) (Math.random()*10);
          code += String.valueOf(number);
        }
        model.addAttribute("code",code);
        return "list";
    }

}
