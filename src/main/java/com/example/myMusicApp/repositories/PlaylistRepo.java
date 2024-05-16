package com.example.myMusicApp.repositories;

import com.example.myMusicApp.entities.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepo extends JpaRepository<PlaylistEntity , Integer> {
}
