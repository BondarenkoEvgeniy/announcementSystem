package com.senla.security;

import com.senla.api.service.IUserService;
import com.senla.config.ExtendedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationGetUser {

    @Autowired
    private IUserService userService;
    @Autowired
    private ExtendedModelMapper modelMapper;

}