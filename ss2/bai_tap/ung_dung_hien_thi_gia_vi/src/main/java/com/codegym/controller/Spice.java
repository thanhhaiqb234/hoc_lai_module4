package com.codegym.controller;

import com.codegym.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spice")
public class Spice {

    @Autowired
    private ISpiceService spiceService;

    @GetMapping("/form")
    public String showForm(){
        return "index";
    }

    @PostMapping("/form")
    public String chooseSpice(@RequestParam(value = "spice" , required = false,defaultValue = "let you choice")
                              String[] spice ,
                              Model model){
        model.addAttribute("spice" , spice);
        return "index";
    }
}
