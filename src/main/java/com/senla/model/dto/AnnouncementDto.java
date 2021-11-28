package com.senla.model.dto;

import com.senla.model.AnnouncementStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AnnouncementDto {
    private Long id;
    private String name;
    private UserDto userDto;
    private String Description;
    private LocalDate postingDate;
    private List<CommentDto> comments;
    private AnnouncementStatus announcementStatus;
    private Double price;
}
