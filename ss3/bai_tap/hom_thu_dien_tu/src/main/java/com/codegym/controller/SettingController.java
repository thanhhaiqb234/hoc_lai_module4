package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private ISettingService settingService;

    @GetMapping("/list")
    public String showSettingList(Model model){
        List<Mail> settings = settingService.getAll();
        model.addAttribute("settings",settings);
        return "index";
    }

    @GetMapping("/edit/form/{id}")
    public String showForm(Model model,
                           @PathVariable int id){
        Mail setting = settingService.editSetting(id);
        List<Integer> integerList = settingService.getAllSize();
        List<String> stringList = settingService.getAllLanguages();
        model.addAttribute("setting",setting);
        model.addAttribute("integerList",integerList);
        model.addAttribute("stringList",stringList);
        return "edit";
    }

    @PostMapping("/form/update")
    public String updateSetting(RedirectAttributes redirectAttributes ,
                                @ModelAttribute Mail mail){
        settingService.updateSetting(mail);
        return "redirect:/setting/list";
    }
}
