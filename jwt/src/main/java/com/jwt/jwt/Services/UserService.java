package com.jwt.jwt.Services;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.jwt.Models.User;
import com.jwt.jwt.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User creatUser(User user){

        user.setUserID(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    
}
