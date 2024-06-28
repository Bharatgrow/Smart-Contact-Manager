package com.hotel.hotelservice.service;

import com.hotel.hotelservice.entity.Hotel;
import com.hotel.hotelservice.exception.ResourceNotFoundException;
import com.hotel.hotelservice.repositories.HotelRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepositories hotelRepositories;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepositories.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepositories.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepositories.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel not found with gievn id"));
    }
}
