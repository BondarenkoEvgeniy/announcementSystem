package com.senla.model.dto.filter;

import com.senla.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingFilter {
    private Long id;
    private Double rating;
    private User messageToUser;
    private User messageFromUser;
}
