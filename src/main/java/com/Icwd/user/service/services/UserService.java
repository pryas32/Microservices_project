package com.Icwd.user.service.services;

import com.Icwd.user.service.entities.User;

import java.util.List;

public interface  UserService {

    //for performing operatioin we need to have logic for that servuice is there


  User saveuser(User user);


  List<User> getAllUser();

  User getUser(String userId);
//jab Id banaya tha toh waha bhi String hi li thi user_id




}
