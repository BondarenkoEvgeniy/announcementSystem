package com.senla.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageDto {
    private Long id;
    private UserDto messageToUser;
    private UserDto messageFromUser;
    private String messageText;
    private LocalDate messageDate;
}
