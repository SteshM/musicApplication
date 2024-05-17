package com.example.myMusicApp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "playlistSongs")

public class PlaylistSongsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistSongsId;
    private int songId;
    private int playlist_id;
}
