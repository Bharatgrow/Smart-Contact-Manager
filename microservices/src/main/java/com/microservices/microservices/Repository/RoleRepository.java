package com.microservices.microservices.Repository;

import com.microservices.microservices.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
