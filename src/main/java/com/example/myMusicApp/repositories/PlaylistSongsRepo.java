package com.example.myMusicApp.repositories;

import com.example.myMusicApp.entities.PlaylistSongsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistSongsRepo extends JpaRepository<PlaylistSongsEntity,Integer> {
    @Query("FROM PlaylistSongsEntity p WHERE p.playlist_id = ?1")
    public List<PlaylistSongsEntity>findByPlaylistId(int playlistId);
}
