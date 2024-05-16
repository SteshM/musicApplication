package com.example.myMusicApp.services;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.SongDTO;
import com.example.myMusicApp.entities.SongEntity;
import com.example.myMusicApp.repositories.SongRepository;
import com.example.myMusicApp.repositories.UserRepository;
import com.example.myMusicApp.utilities.Utilities;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class SongService {
    SongRepository songRepo;
    UserRepository userRepository;

    public ResponseDTO addSong(SongDTO songDTO,int id) {
        var userEntity = userRepository.findByUserId(id);
        if(userEntity.getUserType().name().equals("Artist")){
            var songEntity = new SongEntity();
            songEntity.setTitle(songDTO.getTitle());
            songEntity.setGenre(songDTO.getGenre());
            songEntity.setReleaseYear(songDTO.getReleaseYear());
            songEntity.setDuration(songDTO.getDuration());
            songEntity.setUserEntity(userEntity);
            songRepo.save(songEntity);
            return Utilities.createSuccessfulResponse("Successfully added a song",songDTO);
        } else {
            return Utilities.createFailedResponse(403,"forbidden to create a song");

        }


    }
}
