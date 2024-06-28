package com.microservices.microservices.Repository;

import com.microservices.microservices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}


