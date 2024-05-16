package com.example.myMusicApp.services;

import com.example.myMusicApp.DTOs.PlaylistDTO;
import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.entities.PlaylistEntity;
import com.example.myMusicApp.repositories.PlaylistRepo;
import com.example.myMusicApp.utilities.Utilities;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class PlaylistService {
    @Autowired
    PlaylistRepo playlistRepo;

    public ResponseDTO createPlaylist(PlaylistDTO playlistDTO) {
        ModelMapper modelMapper = new ModelMapper();
        PlaylistEntity playlist = modelMapper.map(playlistDTO,PlaylistEntity.class);
        playlistRepo.save(playlist);
        return Utilities.createSuccessfulResponse("Successfully created a playlist",playlist);

    }
}
