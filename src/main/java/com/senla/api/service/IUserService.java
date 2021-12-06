package com.senla.api.service;

import com.senla.model.dto.UserDto;

public interface IUserService {

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);

    UserDto getByUsername(String username);

    UserDto getCurrentUserProfile();
}
