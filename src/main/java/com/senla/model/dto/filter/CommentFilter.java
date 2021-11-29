package com.senla.model.dto.filter;

import com.senla.model.dto.AnnouncementDto;
import com.senla.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentFilter {
    private Long id;
    private UserDto user;
    private AnnouncementDto announcement;
    private String commentText;
    private LocalDate commentDate;
}
