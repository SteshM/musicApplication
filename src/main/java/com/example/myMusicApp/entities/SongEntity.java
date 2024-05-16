package com.example.myMusicApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "songs")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;
    private String title;
    private String genre;
    private int releaseYear;
    private int duration;
    @ManyToOne()
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

}
