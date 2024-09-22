package com.senla.security;

import com.senla.api.service.IUserService;
import com.senla.config.ExtendedModelMapper;
import com.senla.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Autowired
    private ExtendedModelMapper modelMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = modelMapper.map(userService.getByUsername(username), User.class);
        CustomUserDetails customUserDetails = modelMapper.map(user.getUserLogin(), CustomUserDetails.class);
        customUserDetails.setGrantedAuthorities( Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().name())));
        return customUserDetails;
    }
}