package com.example.myMusicApp.controller;

import com.example.myMusicApp.DTOs.PlaylistDTO;
import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.services.PlaylistService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Data
@RequestMapping
public class PlaylistController {
   private final PlaylistService playlistService;

    @PostMapping("/playlist")
    public ResponseDTO createPlaylist(@RequestBody PlaylistDTO playlistDTO){
        return playlistService.createPlaylist(playlistDTO);
    }

}
