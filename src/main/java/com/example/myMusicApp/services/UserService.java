package com.example.myMusicApp.services;

import com.example.myMusicApp.DTOs.ResponseDTO;
import com.example.myMusicApp.DTOs.UserDTO;
import com.example.myMusicApp.entities.UserEntity;
import com.example.myMusicApp.enums.UserType;
import com.example.myMusicApp.repositories.UserRepository;
import com.example.myMusicApp.utilities.Utilities;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Data
@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public ResponseDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        try{
            userEntity.setUserType(UserType.valueOf(userDTO.getUserType()));
        }catch(Exception e){
            return Utilities.createFailedResponse(401,"Bad user type");
        }
        userRepo.save(userEntity);
        return Utilities.createSuccessfulResponse("Successfully created user",userEntity);
    }

    public ResponseDTO fetchUsers() {
        List<UserEntity>userEntityList=userRepo.findAll();
        return Utilities.createSuccessfulResponse("successfully fetched all users",userEntityList);
    }

    public ResponseDTO fetchUserById(int userId) {
    List<UserEntity>userEntityList = userRepo.findByUserId(userId);
    return Utilities.createSuccessfulResponse("successfully fetched a user by Id",userEntityList);

    }

    public ResponseDTO updateUserById(UserDTO userDTO, int id) {

    }
}
