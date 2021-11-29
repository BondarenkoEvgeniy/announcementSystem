package com.senla.dao;

import com.senla.api.dao.IRatingDao;
import com.senla.model.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RatingDao extends AbstractDao<Rating> implements IRatingDao {
    @Override
    protected Class<Rating> getClazz() {
        return Rating.class;
    }
}
