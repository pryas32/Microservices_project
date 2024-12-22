package com.Icwd.user.service;

import com.Icwd.user.service.entities.Rating;
import com.Icwd.user.service.external.services.RATING_SERVICE;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RATING_SERVICE ratingService;

	@Test
	void createRating() {
		Rating rating = new Rating.Builder()
				.userId(" ")       // Replace with actual userId
				.hotelId("")       // Replace with actual hotelId
				.rating("10")
				.feedback("hello how are you")// Replace with actual rating value
				.build();

		Rating rating1 = ratingService.createRating(rating);

		System.out.println("New rating created");
	}






}
