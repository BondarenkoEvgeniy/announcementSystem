package com.senla.model.dto.filter;

import com.senla.model.AnnouncementStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnnouncementFilter {
    private Long id;
    private String name;
    private Long userId;
    private LocalDate postingDate;
    private AnnouncementStatus announcementStatus;
    private Double priceTo;
    private Double priceFrom;
    private String orderBy;
    private String orderDirection;
}
