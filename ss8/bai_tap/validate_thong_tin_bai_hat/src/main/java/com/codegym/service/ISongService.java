package com.codegym.service;

import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> getAllSong(Pageable pageable);

    Song getSong(int id);

    void updateSong(Song song);

    void createSong(Song song);
}
