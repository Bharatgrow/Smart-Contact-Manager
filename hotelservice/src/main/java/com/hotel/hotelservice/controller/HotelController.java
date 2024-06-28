package com.hotel.hotelservice.controller;

import com.hotel.hotelservice.entity.Hotel;
import com.hotel.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

  //  @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //@PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(id));
    }

    //@PreAuthorize("hasAuthority('SCOPE_internal')||('admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
