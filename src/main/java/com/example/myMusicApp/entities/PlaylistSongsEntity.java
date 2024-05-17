package com.example.myMusicApp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "playlistSongs")

public class PlayListSongsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playlistSongsId;

    @JoinColumn(name = "songsId")
    private int songId;

    @JoinColumn(name = "playlist_id")
    private int playlist_id;
}
