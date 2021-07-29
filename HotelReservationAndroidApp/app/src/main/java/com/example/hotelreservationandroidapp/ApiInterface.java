package com.example.hotelreservationandroidapp;





import com.example.hotelreservationandroidapp.GuestData;
import com.example.hotelreservationandroidapp.HotelListData;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;

import retrofit.http.POST;


public interface ApiInterface {

    // API's endpoints
    @GET("/hotelsList")
    public void getHotelsLists(Callback<List<HotelListData>> callback);



    @POST("/reservationConfirmation")
    public  void postGuestDetails(@Body GuestData guestData, Callback<Object> obj);

    
}
