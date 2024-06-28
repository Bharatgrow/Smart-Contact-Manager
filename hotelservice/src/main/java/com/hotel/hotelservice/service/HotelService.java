package com.hotel.hotelservice.service;


import com.hotel.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotelById(String id) ;

}
