package com.microservices.microservices.Service;

import com.microservices.microservices.Entity.Hotel;
import com.microservices.microservices.Entity.Rating;
import com.microservices.microservices.Entity.Role;
import com.microservices.microservices.Entity.User;
import com.microservices.microservices.Exception.ResourceNotFoundException;
import com.microservices.microservices.Repository.RoleRepository;
import com.microservices.microservices.Repository.UserRepository;
import com.microservices.microservices.external.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);


        System.out.println();
       
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {


        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found with given Id"+userId));

   Rating[] ratingsOfUser=    restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(), Rating[].class);

    logger.info("{}",ratingsOfUser);

        List<Rating>ratings=Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
//       ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//      logger.info("return status code",forEntity.getStatusCode());
    rating.setHotel(hotel);



        return rating;
    }).collect(Collectors.toList());


        user.setRatings(ratingList);

        System.out.println(ratingList);
        System.out.println(user);

        // for role

//        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found with given Id"+userId));

        Role[] roleOfUser=    restTemplate.getForObject("http://ROLE/role/"+user.getUserId(), Role[].class);

        logger.info("{}",roleOfUser);

        List<Role>role=Arrays.stream(roleOfUser).toList();

        user.setRoles(role);



        return  user;
    }
}
