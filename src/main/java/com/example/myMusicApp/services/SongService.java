package com.example.myMusicApp.services;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.SongDTO;
import com.example.myMusicApp.entities.SongEntity;
import com.example.myMusicApp.repositories.SongRepository;
import com.example.myMusicApp.utilities.Utilities;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class SongService {
    @Autowired
    SongRepository songRepo;

    public ResponseDTO addSong(SongDTO songDTO) {
        SongEntity songEntity = new SongEntity();
        songEntity.setTitle(songDTO.getTitle());
        songEntity.setGenre(songDTO.getGenre());
        songEntity.setReleaseYear(songDTO.getReleaseYear());
        songEntity.setDuration(songDTO.getDuration());
        songRepo.save(songEntity);
        return Utilities.createSuccessfulResponse("Successfully added a song",songDTO);


    }
}
