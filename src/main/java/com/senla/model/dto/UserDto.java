package com.senla.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senla.model.UserRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    Long id;
    String name;
    String email;
    String phone;
    @JsonIgnore
    List<AnnouncementDto> announcements;
    @JsonIgnore
    List<MessageDto> messages;
    LocalDate registrationDate;
    UserRole userRole;
}
