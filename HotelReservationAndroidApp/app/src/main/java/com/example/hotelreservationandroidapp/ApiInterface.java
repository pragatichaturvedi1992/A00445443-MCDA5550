package com.example.hotelreservationandroidapp;

import android.telecom.Call;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;


public interface ApiInterface {

    // API's endpoints
    @GET("/hotelsList")
    public void getHotelsLists(Callback<List<HotelListData>> callback);

    @POST("/reservationsConfirmations")
    public  void postGuestDetails(@Body HotelGuestData guestData, Callback<Object> obj);;
    
}
