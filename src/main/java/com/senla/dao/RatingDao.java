package com.senla.dao;

import com.senla.api.dao.IRatingDao;
import com.senla.model.Rating;
import com.senla.model.dto.filter.RatingFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RatingDao extends AbstractDao<Rating> implements IRatingDao {
    @Override
    protected Class<Rating> getClazz() {
        return Rating.class;
    }

    @Override
    public List<Rating> getByFilter(RatingFilter ratingFilter) {
        return null;
    }
}
