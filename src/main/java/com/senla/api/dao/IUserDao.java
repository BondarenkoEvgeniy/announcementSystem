package com.senla.api.dao;

import com.senla.model.User;

import java.util.List;

public interface IUserDao {
    User getById(Long id);

    void save (User user);

    User update(User user);

    void delete(User user);

    List<User> getAll();
}
