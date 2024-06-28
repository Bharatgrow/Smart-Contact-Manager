package com.hotel.hotelservice.repositories;

import com.hotel.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepositories extends JpaRepository<Hotel,String> {
}
