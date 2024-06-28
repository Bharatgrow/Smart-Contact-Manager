package com.microservices.microservices.external.services;

import com.microservices.microservices.Entity.Rating;
import com.microservices.microservices.Entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name="ROLE")
public interface RoleService {

    @PostMapping("/role")
    public ResponseEntity<Role> createRating(Role values);

}
