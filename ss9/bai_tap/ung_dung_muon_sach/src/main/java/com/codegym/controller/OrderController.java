package com.codegym.controller;

import com.codegym.model.Books;
import com.codegym.model.Orders;
import com.codegym.service.IBookService;
import com.codegym.service.IOrderService;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        if (books.getQuantity() == 0){
            return "redirect:/book/list";
        }
        Orders orders = new Orders();
        String code = "";
        for (int i = 0; i < 5; i++) {
            int number = (int) (Math.random()*10);
          code += String.valueOf(number);
        }
        orders.setBooks(books);
        model.addAttribute("code",code);
        model.addAttribute("orders",orders);
        model.addAttribute("books",books);
        return "order";
    }

    @PostMapping("/book")
    public String orderBook(@ModelAttribute Orders orders){
        orderService.createOrder(orders);
        Books id = orders.getBooks();
        Books books = bookService.finById(id.getId());
        books.setQuantity(books.getQuantity() - 1);
        bookService.orderBook(books);
        return "redirect:/book/list";
    }

    @GetMapping("/returns/form/{id}")
    public String formReturnsBook(@PathVariable int id,
                                  Model model){
        Books books = bookService.finById(id);
        model.addAttribute("books",books);
        return "returns";
    }
    @PostMapping("/returns/book")
    public String returnsBook(@RequestParam(name = "borrowcCode") String borrowcCode ,
                              Model model,
                              @ModelAttribute Books books){
        books = bookService.finById(books.getId());
        Orders orders = orderService.getOrder(borrowcCode);
        if (orders == null){
            String message = "Bạn đã nhập sai mã thẻ xin vui lòng nhập lại";
            model.addAttribute("message", message);
            model.addAttribute("books",books);
            model.addAttribute("borrowcCode",borrowcCode);
            return "returns";
        }
        orderService.returnsBook(orders);
        books.setQuantity(books.getQuantity() + 1);
        bookService.returnsBook(books);
        return "redirect:/book/list";
    }

}
