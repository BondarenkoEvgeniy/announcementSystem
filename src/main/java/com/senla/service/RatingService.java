package com.senla.service;

import com.senla.api.dao.IRatingDao;
import com.senla.api.dao.IUserDao;
import com.senla.api.service.IRatingService;
import com.senla.api.service.IUserService;
import com.senla.config.ExtendedModelMapper;
import com.senla.model.Rating;
import com.senla.model.User;
import com.senla.model.dto.RatingDto;
import com.senla.model.dto.filter.RatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RatingService implements IRatingService {
    @Autowired
    private IRatingDao ratingDao;
    @Autowired
    private ExtendedModelMapper modelMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserDao userDao;

    @Override
    public void createRating(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        ratingDao.save(rating);
    }

    @Override
    public void giveRatingToUser(Long id, RatingDto ratingDto) {
        User sender = modelMapper.map(userService.getCurrentUserProfile(), User.class);
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        rating.setRatingFromUser(sender);
        if (rating.getRatingFromUser().equals(rating.getRatingToUser())) {
            try {
                throw new Exception("Вы не можете поставить себе оценку.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RatingFilter ratingFilter = new RatingFilter();
        ratingFilter.setRatingFromUser(rating.getRatingFromUser());
        ratingFilter.setRatingToUser(rating.getRatingToUser());
        if (ObjectUtils.isEmpty(ratingDao.getByFilter(ratingFilter))) {
            ratingDao.save(rating);
            RatingFilter ratingFilter2 = new RatingFilter();
            ratingFilter2.setRatingToUser(rating.getRatingToUser());
            User receiver = userDao.getById(rating.getRatingToUser().getId());
            List<Rating> ratings = ratingDao.getByFilter(ratingFilter2);
            int sum = 0;
            for (Rating value : ratings) {
                sum += value.getRating();
            }
            Double avgRating = (double) (sum / ratings.size());
            userDao.update(receiver);
        }
        if (!ObjectUtils.isEmpty(ratingDao.getByFilter(ratingFilter))) {
            try {
                throw new Exception("Пользователь уже получил от Вас оценку.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
