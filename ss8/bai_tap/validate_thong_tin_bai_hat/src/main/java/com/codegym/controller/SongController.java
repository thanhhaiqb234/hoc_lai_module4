package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public String getAllSong(Model model,
                             Pageable pageable,
                             @RequestParam(defaultValue = "0", required = false) int page) {
        pageable = PageRequest.of(page, 3);
        Page<Song> songPage = songService.getAllSong(pageable);
        model.addAttribute("songPage", songPage);
        return "list";
    }

    @GetMapping("/form/edit/{id}")
    public String getSong(@Validated SongDto songDto,
                          Model model,
                          @PathVariable int id) {
        Song song = songService.getSong(id);
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "edit";
    }
    @PostMapping("/update/song")
    public String updateSong(@Validated @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             Model model){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.updateSong(song);
            return "redirect:/song/list";
        }
    }

    @GetMapping("/form/create")
    public String showFormCreate(Model model){
        model.addAttribute("songDto",new SongDto());
        return "create";
    }

    @PostMapping("/create/song")
    public String createSong(@Validated @ModelAttribute SongDto songDto,
                             BindingResult bindingResult){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.createSong(song);
            return "redirect:/song/list";
        }
    }

}
