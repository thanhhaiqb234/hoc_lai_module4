package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> getAllSong(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Song getSong(int id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void createSong(Song song) {
        songRepository.save(song);
    }

}
