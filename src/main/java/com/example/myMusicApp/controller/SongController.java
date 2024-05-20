package com.example.myMusicApp.controller;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.SongDTO;
import com.example.myMusicApp.services.SongService;
import com.example.myMusicApp.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SongController {
    @Autowired
    SongService songService;

    @PostMapping("/{userId}/song")
    public ResponseDTO addSong(@RequestBody SongDTO songDTO, @PathVariable int userId){
        return songService.addSong(songDTO,userId);
    }
    @GetMapping("/get-songs/{userid}")
    public ResponseDTO getSongsByUserId(int user_id)
    {
        return songService.getSongsByUserId(user_id);
    }
}
