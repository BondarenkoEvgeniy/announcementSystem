package com.senla.api.dao;

import com.senla.model.Rating;

import java.util.List;

public interface IRatingDao {
    Rating getById(Long id);

    void save (Rating rating);

    Rating update(Rating rating);

    void delete(Rating rating);

    List<Rating> getAll();
}
