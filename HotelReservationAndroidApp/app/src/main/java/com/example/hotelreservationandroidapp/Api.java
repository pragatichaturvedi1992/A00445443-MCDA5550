package com.example.hotelreservationandroidapp;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {

        // change your base URL
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://hotelreservation-env.eba-aptctgjw.us-east-1.elasticbeanstalk.com") //Set the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }
}
