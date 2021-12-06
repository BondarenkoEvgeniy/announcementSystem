package com.senla.model.dto;

import com.senla.model.User;
import lombok.Data;

@Data
public class RatingDto {
    private Long id;
    private Double rating;
    private User ratingToUser;
    private User ratingFromUser;
}
