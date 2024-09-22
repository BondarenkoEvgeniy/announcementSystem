package com.senla.service;

import com.senla.api.dao.IUserDao;
import com.senla.api.service.IUserService;
import com.senla.config.ExtendedModelMapper;
import com.senla.model.User;
import com.senla.model.dto.UserDto;
import com.senla.model.dto.filter.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private ExtendedModelMapper modelMapper;

    @Override
    public void createUser(UserDto userDto) {
        User user = modelMapper.map( userDto, User.class );
        user.setRegistrationDate( LocalDate.now() );
        userDao.save( user );
    }

    @Override
    public void updateUser(UserDto userDto) {
        User userFirst = modelMapper.map( userDto, User.class );
        User userSecond = userDao.getById( userDto.getId() );
        userSecond.setName( userFirst.getName() );
        userSecond.setEmail( userFirst.getEmail() );
        userSecond.setPhone( userFirst.getPhone() );
        userDao.update( userSecond );
    }

    @Override
    public void deleteUser(Long id){
        User user = userDao.getById( id );
        userDao.delete( user );
    }

    @Override
    public UserDto getByUsername(String username) {
        UserFilter userFilter = new UserFilter();
        userFilter.setName(username);
        User user = userDao.getByFilter(userFilter).stream()
                .findFirst()
                .orElse(null);
        if (user != null) {
            return modelMapper.map(user, UserDto.class);
        } else {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
    }

    @Override
    public UserDto getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return getByUsername(currentPrincipalName);
    }
}
