package com.senla.dao;

import com.senla.api.dao.IUserDao;
import com.senla.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDao extends AbstractDao<User> implements IUserDao {

    @Override
    protected Class<User> getClazz() {
        return User.class;
    }
}
