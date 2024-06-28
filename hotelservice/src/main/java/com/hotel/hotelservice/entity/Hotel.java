package com.hotel.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
