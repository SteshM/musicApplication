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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            ModelMapper modelMapper = new ModelMapper();

            UserEntity userEntity =modelMapper.map(userDTO, UserEntity.class);
//            userEntity.setUserType(UserType.valueOf(userDTO.getUserType()));
            userRepo.save(userEntity);
            return Utilities.createSuccessfulResponse("Successfully created user", userEntity);
        } catch (IllegalArgumentException e) {
            log.error("Caught Argument Exception: ", e);
            return Utilities.createFailedResponse(401, "Bad user type: " + userDTO.getUserType());
        } catch (DataIntegrityViolationException e) {
            log.error("Caught exception:", e);
            return Utilities.createFailedResponse(409, "Email already exists");
        } catch (Exception e) {
            log.error("Caught a generic exception: ", e);
            return Utilities.createFailedResponse(500, "Generic exception");
        }


    }

    public ResponseDTO fetchUsers() {
        List<UserEntity> userEntityList = userRepo.findAll();
        return Utilities.createSuccessfulResponse("successfully fetched all users", userEntityList);
    }

    public ResponseDTO fetchUserById(int userId) {
        UserEntity userEntity = userRepo.findByUserId(userId);
        return Utilities.createSuccessfulResponse("successfully fetched a user by Id", userEntity);

    }

    public ResponseDTO updateUserById(UserDTO userDTO, int id) {
        UserEntity userEntity = userRepo.findByUserId(id);
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        try {
            userEntity.setUserType(UserType.valueOf(userDTO.getUserType()));
        } catch (Exception e) {
            return Utilities.createFailedResponse(401, "Bad user type");
        }
        userRepo.save(userEntity);
        return Utilities.createSuccessfulResponse("Successfully updated user", userEntity);

    }

    public ResponseDTO deleteUserById(int id) {
        userRepo.deleteById(id);
        return Utilities.createSuccessfulResponse("Successfully deleted a user", id);
    }
}
