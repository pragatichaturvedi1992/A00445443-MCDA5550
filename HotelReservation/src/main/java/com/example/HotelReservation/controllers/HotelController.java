package com.example.HotelReservation.controllers;

import java.util.*;

import com.example.HotelReservation.entities.Confirmation;
import com.example.HotelReservation.entities.HotelDetails;
import com.example.HotelReservation.entities.ReservationDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

@RequestMapping("/hotelsList")
public List<HotelDetails> getHotelsList(){
    return getListOfHotels();
}

public List<HotelDetails> getListOfHotels(){
    List<HotelDetails> hotelsList = new ArrayList<HotelDetails>();
    List<String> hotelNames = Arrays.asList("Season Inn", "Comfort Inn", "Hampton Inn", "Woodland Inn");
    Random random = new Random();
    for (int i=0; i<hotelNames.size();i++){
        HotelDetails hoteldetails = new HotelDetails();
        hoteldetails.setHotel_name(hotelNames.get(i));
        boolean avail = random.nextBoolean();
        hoteldetails.setAvailability(avail);

        int randomPrice = random.nextInt(300 -50+1) + 50;
        hoteldetails.setPrice(randomPrice);
        hotelsList.add(hoteldetails);
        hoteldetails =null;
    }

    return hotelsList;
}

@RequestMapping(value = "/reservationConfirmation" , method = RequestMethod.POST, consumes = "application/json")
public Confirmation reserveHotel(@RequestBody ReservationDetails reservationDetails){
return new Confirmation();
}
}
