package com.senla.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDto {
    Long id;
    UserDto user;
    @JsonIgnore
    AnnouncementDto announcement;
    String commentText;
    LocalDate commentDate;

}
