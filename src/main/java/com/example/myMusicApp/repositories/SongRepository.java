package com.example.myMusicApp.repositories;

import com.example.myMusicApp.entities.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity,Integer> {
}
