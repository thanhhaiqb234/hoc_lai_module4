package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSong;
    private String nameSong;
    private String artistName;
    private String  categorySong;

    public Song() {
    }

    public Song(int idSong, String nameSong, String artistName, String categorySong) {
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

}
