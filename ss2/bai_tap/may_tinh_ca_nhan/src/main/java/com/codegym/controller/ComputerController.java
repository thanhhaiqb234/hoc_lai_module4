package com.codegym.controller;

import com.codegym.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private IComputerService computerService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/computer/sum")
    private String computerSum(@RequestParam(name = "number1" , required = false , defaultValue = "Please choose") double inputNumber1 ,
                               @RequestParam(name = "number2" , required = false , defaultValue = "Please choose") double inputNumber2 ,
                               @RequestParam(value = "calculation") String calculation , Model model){
        double sum = computerService.sumInputNumber(inputNumber1,inputNumber2,calculation);
        if (inputNumber2 != 0){
            model.addAttribute("sum",sum);
        }else {
            model.addAttribute("message", "Cannot make this calculate with inputNumber 2 = zero");
        }
        return "index";
    }
}
