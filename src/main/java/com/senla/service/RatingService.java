package com.senla.service;

import com.senla.api.dao.IRatingDao;
import com.senla.api.service.IRatingService;
import com.senla.config.ModelMapperMapList;
import com.senla.model.Rating;
import com.senla.model.dto.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RatingService implements IRatingService {
    @Autowired
    private IRatingDao ratingDao;
    @Autowired
    private ModelMapperMapList modelMapper;

    @Override
    public void createRating(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        ratingDao.save(rating);
    }

    @Override
    public void giveRatingToUser(Long id, RatingDto ratingDto) {

    }

}
