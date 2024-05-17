package com.example.myMusicApp.services;

import com.example.myMusicApp.DTOs.PlaylistDTO;
import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.SongDTO;
import com.example.myMusicApp.entities.PlaylistEntity;
import com.example.myMusicApp.entities.PlaylistSongsEntity;
import com.example.myMusicApp.entities.SongEntity;
import com.example.myMusicApp.repositories.PlaylistRepo;
import com.example.myMusicApp.repositories.PlaylistSongsRepo;
import com.example.myMusicApp.repositories.SongRepository;
import com.example.myMusicApp.utilities.Utilities;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class PlaylistService {
    private static final Logger log = LoggerFactory.getLogger(PlaylistService.class);
    @Autowired
    PlaylistRepo playlistRepo;

    @Autowired
    PlaylistSongsRepo playlistSongsRepo;
    @Autowired
    SongRepository songRepository;

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

    public ResponseDTO deletePlaylist(int id) {
        playlistRepo.deleteById(id);
        return Utilities.createSuccessfulResponse("Deleted playlist",id);
    }

    public ResponseDTO addSongsToPlaylist(List<Integer> songIds, int playlistId){
        ArrayList<PlaylistSongsEntity> playlistSongsEntities = new ArrayList<>();
        for(int songId: songIds){
            PlaylistSongsEntity playlistSongs = new PlaylistSongsEntity();
            playlistSongs.setPlaylist_id(playlistId);
            playlistSongs.setSongId(songId);
            playlistSongsEntities.add(playlistSongs);
        }
        playlistSongsRepo.saveAll(playlistSongsEntities);
        return Utilities.createSuccessfulResponse("success", playlistSongsEntities);
    }

    public ResponseDTO getPlaylistSongs(int playlistId){
        List<PlaylistSongsEntity> playlistSongsEntity = playlistSongsRepo.findByPlaylistId(playlistId);
        List<Integer> playlistSongsIds = new ArrayList<>();
        for(PlaylistSongsEntity playlistSong: playlistSongsEntity){
            log.info(""+playlistSong.getPlaylist_id());
            playlistSongsIds.add(playlistSong.getSongId());
        }
        List<SongEntity> songs = songRepository.findAllById(playlistSongsIds);
        
        return Utilities.createSuccessfulResponse("success", songs);

    }
}
