package com.example.myMusicApp.DTOs;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
public class ResponseDTO {
    private int statusCode;
    private String statusDescription;
    private List<?> data;
}
