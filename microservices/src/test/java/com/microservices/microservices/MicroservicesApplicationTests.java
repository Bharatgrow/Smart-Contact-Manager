package com.microservices.microservices;

import com.microservices.microservices.Entity.Rating;
import com.microservices.microservices.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class MicroservicesApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingService ratingService;
//	@Test
//	void createRating(){
//
//		Rating rating=Rating.builder().rating(10).hotelId("").userId("").feedback("ok").build();
//		Rating saveRating=ratingService.createRating(rating);
//		System.out.println("done");
//	}

}
