package com.example.HotelReservation.entities;

public enum Gender {
    MALE(1), FEMALE(2), NONIDENTIFIED(3);
 
    private int code;
     
    Gender(int code) {
        this.code = code;
    }
 
    public int getCode() {
        return code;
    }
}