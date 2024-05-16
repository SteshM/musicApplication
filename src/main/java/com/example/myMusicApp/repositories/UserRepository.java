package com.example.myMusicApp.repositories;

import com.example.myMusicApp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserId(int userId);


}
