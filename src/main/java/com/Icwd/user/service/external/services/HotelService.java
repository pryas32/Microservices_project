package com.Icwd.user.service.external.services;

import com.Icwd.user.service.entities.hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
    hotel getHotel(@PathVariable("hotelId") String hotelId);





}
