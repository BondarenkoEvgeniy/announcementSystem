package com.senla.dao;

import com.senla.api.dao.IUserDao;
import com.senla.model.User;
import com.senla.model.dto.filter.UserFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDao extends AbstractDao<User> implements IUserDao {

    @Override
    protected Class<User> getClazz() {
        return User.class;
    }

    @Override
    public List<User> getByFilter(UserFilter userFilter) {
        return null;
    }
}
