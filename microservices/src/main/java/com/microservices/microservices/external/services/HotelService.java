package com.microservices.microservices.external.services;

import com.microservices.microservices.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HotelService")
public interface HotelService {

    @GetMapping("/hotels/{id}")
     Hotel getHotel(@PathVariable("id") String id);
}
