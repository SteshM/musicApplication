package com.example.myMusicApp.entities;

import com.example.myMusicApp.enums.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private UserType userType;

    @JsonBackReference
    @OneToMany
    @JoinColumn(name="songId")
    private List<SongEntity> songs = new ArrayList<>();
}
