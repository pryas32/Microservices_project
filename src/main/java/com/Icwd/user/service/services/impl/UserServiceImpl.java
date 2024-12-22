package com.Icwd.user.service.services.impl;

import com.Icwd.user.service.Repositories.UserRepository;
import com.Icwd.user.service.entities.Rating;
import com.Icwd.user.service.entities.User;
import com.Icwd.user.service.entities.hotel;
import com.Icwd.user.service.exceptions.ResourceNotFoundException;
import com.Icwd.user.service.external.services.HotelService;
import com.Icwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserService.class);


    @Autowired
    private HotelService hotelService;


    @Autowired
    private UserRepository userRepository;



    @Override
    public User saveuser(User user) {
        String randomUserId= UUID.randomUUID().toString();//generates unique user_Id in string format
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id isnt found on server"+userId));
        //getting user from database with the help of user repository
        //
        //now work is to fetch rating of the above user from rating service


        Rating[] forObject=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",forObject);

        List<Rating> ratings= Arrays.stream(forObject).toList();

        List<Rating> ratingList=ratings.stream().map(rating -> {


         //   ResponseEntity<hotel>forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(),hotel.class);
           // hotel hotel=forEntity.getBody();
          hotel hotels=hotelService.getHotel(rating.getHotelId());

           // logger.info("response status code:{} ",forEntity.getStatusCode());


            rating.setHotel(hotels);

            return rating;
        }).collect(Collectors.toList());




        user.setRatings(ratingList);
        return user;
    }
}
