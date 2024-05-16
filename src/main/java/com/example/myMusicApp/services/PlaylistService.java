package com.example.myMusicApp.services;

import com.example.myMusicApp.DTOs.PlaylistDTO;
import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.entities.PlaylistEntity;
import com.example.myMusicApp.repositories.PlaylistRepo;
import com.example.myMusicApp.utilities.Utilities;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ResponseDTO fetchAll() {
        List<PlaylistEntity>playlistEntityList = playlistRepo.findAll();
        return Utilities.createSuccessfulResponse("Fetched all playlists",playlistEntityList);
    }

    public ResponseDTO updatePlaylist(PlaylistDTO playlistDTO, int id) {
        PlaylistEntity playlist = playlistRepo.findByPlaylistId(id);
        ModelMapper modelMapper = new ModelMapper();
        PlaylistEntity playlist1 = modelMapper.map(playlistDTO, PlaylistEntity.class);
        playlist1.setPlaylistId(playlist.getPlaylistId());
        playlistRepo.save(playlist1);
        return Utilities.createSuccessfulResponse("Updated playlist",playlist1);

    }
}
