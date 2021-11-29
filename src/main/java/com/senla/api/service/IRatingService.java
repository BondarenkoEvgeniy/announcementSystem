package com.senla.api.service;

import com.senla.model.dto.RatingDto;

public interface IRatingService {
    void giveRatingToUser(Long id, RatingDto ratingDto);

    void createRating(RatingDto ratingDto);
}
