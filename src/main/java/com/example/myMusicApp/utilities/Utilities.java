package com.example.myMusicApp.utilities;

import com.example.myMusicApp.DTOs.ResponseDTO;

import java.util.List;

public class Utilities {
    public static ResponseDTO createSuccessfulResponse(String message , Object data){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatusCode(200);
        responseDTO.setStatusDescription(message);
        responseDTO.setData(data instanceof List ? (List<?>) data : List.of(data));
        return responseDTO;
        }

public static ResponseDTO createFailedResponse(int statusCode , String message){
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setStatusCode(statusCode);
    responseDTO.setStatusDescription(message);
    return responseDTO;
}
}
