package com.senla.model.dto.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MessageFilter {
    private Long id;
    private Long messageToUser;
    private Long messageFromUser;
    private String messageText;
    private LocalDate messageDate;
}
