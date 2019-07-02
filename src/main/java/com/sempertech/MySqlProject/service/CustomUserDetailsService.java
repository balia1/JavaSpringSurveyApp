package com.sempertech.MySqlProject.service;

import com.sempertech.MySqlProject.repository.UserInterface;
import com.sempertech.MySqlProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserInterface userInterface;

    @Autowired
    public CustomUserDetailsService(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userInterface.findByUsername(username);
        if (users != null) {

            return new User(users.getUsername(),users.getPassword(), AuthorityUtils.createAuthorityList(users.getRole()));
        } else {
            throw new UsernameNotFoundException("User not exist with name : " +username);
        }
    }

}