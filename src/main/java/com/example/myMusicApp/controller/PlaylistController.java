package com.example.myMusicApp.controller;

import com.example.myMusicApp.DTOs.PlaylistDTO;
import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.services.PlaylistService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/playlists")
    public ResponseDTO fetchPlaylists(){
        return playlistService.fetchAll();
    }
    @PutMapping("/playlist/{id}")
    public ResponseDTO updatePlaylist(@RequestBody PlaylistDTO playlistDTO,@PathVariable int id){
        return playlistService.updatePlaylist(playlistDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deletePlaylist(@PathVariable int id){
        return playlistService.deletePlaylist(id);
    }

    @PostMapping("/addToPlaylist/{playlistId}")
    public ResponseDTO addSongsToPlaylist(@RequestBody List<Integer> songIds,@PathVariable int playlistId){
        return playlistService.addSongsToPlaylist(songIds, playlistId);
    }

    @GetMapping("/getPlaylist/{playlistId}")
    public ResponseDTO getPlaylistSongs(@PathVariable int playlistId){
        return  playlistService.getPlaylistSongs(playlistId);
    }
}
