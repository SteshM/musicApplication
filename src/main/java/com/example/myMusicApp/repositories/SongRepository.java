package com.example.myMusicApp.repositories;

import com.example.myMusicApp.entities.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SongRepository extends JpaRepository<SongEntity,Integer> {

    @Query(value = "select * from songs where user_id = ?1", nativeQuery = true)
    List<SongEntity> findByUserId(int user_id);
}
