package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

public class SongDto implements Validator {

    private int idSong;

    private String nameSong;
    private String artistName;
    private String  categorySong;

    public SongDto() {
    }

    public SongDto(int idSong, String nameSong, String artistName, String categorySong) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.artistName = artistName;
        this.categorySong = categorySong;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCategorySong() {
        return categorySong;
    }

    public void setCategorySong(String categorySong) {
        this.categorySong = categorySong;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.nameSong.length() > 800){
            errors.rejectValue("nameSong",null,"Tên bài hát không thể vượt quá 800 ký tự");
        } else if (!songDto.nameSong.matches("^[a-z + A-Z + 0-9]{0,100}$")) {
            errors.rejectValue("nameSong",null,"Tên bài hát không thể chứa các kí tự đặc biệt");
        } else if (songDto.nameSong.equals("")) {
            errors.rejectValue("nameSong",null,"Không được để trống");
        } else if (songDto.artistName.equals("")) {
            errors.rejectValue("artistName",null,"Không được để trống");
        } else if (songDto.artistName.length() > 300) {
            errors.rejectValue("artistName",null,"Tên nghệ sỹ không được quá 300 ký tự");
        } else if (!songDto.artistName.matches("^[a-z + A-Z + 0-9]{0,300}$")) {
            errors.rejectValue("artistName",null,"Tên nghệ sỹ không được chứa các ký tự đặc biệt");
        } else if (songDto.categorySong.equals("")) {
            errors.rejectValue("categorySong",null,"Tên Thể loại nhạc không được để trống");
        } else if (!songDto.categorySong.matches("^[a-z + A-Z + 0-9 + ,]{0,1000}$")) {
            errors.rejectValue("categorySong",null,"Tên bài hát không được chứa các ký tự đặc biệt ngoại từ (,) và tên không được quá 1000 ký tự");
        }
    }
}
