package com.jwt.jwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.jwt.Models.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User,String> {

    public Optional<User>  findByEmail(String email);
    
}
