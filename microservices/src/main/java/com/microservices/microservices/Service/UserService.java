package com.microservices.microservices.Service;

import com.microservices.microservices.Entity.User;

import java.util.List;

public interface UserService {

    User saveUser( User user);

    List<User> getAllUser();

    User getUserById(String userId);
}
