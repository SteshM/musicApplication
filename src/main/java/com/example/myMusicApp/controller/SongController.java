package com.example.myMusicApp.controller;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.SongDTO;
import com.example.myMusicApp.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SongController {
    @Autowired
    SongService songService;

    @PostMapping("/{userId}/song")
    public ResponseDTO addSong(@RequestBody SongDTO songDTO, @PathVariable int id){
        return songService.addSong(songDTO,id);
    }
}
