package com.senla.model.dto.filter;

import com.senla.model.UserRole;
import com.senla.model.dto.AnnouncementDto;
import com.senla.model.dto.MessageDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserFilter {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<AnnouncementDto> announcements;
    private List<MessageDto> messages;
    private LocalDate registrationDate;
    private UserRole userRole;
}
