package com.senla.controller;

import com.senla.api.service.IRatingService;
import com.senla.model.dto.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RatingController {

    @Autowired
    private IRatingService ratingService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody RatingDto ratingDto) {
        ratingService.createRating(ratingDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody Long id, RatingDto ratingDto) {
        ratingService.giveRatingToUser(id, ratingDto);
        return ResponseEntity.noContent().build();
    }
}
