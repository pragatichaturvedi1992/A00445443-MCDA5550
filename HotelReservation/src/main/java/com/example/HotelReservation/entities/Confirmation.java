package com.example.HotelReservation.entities;

public class Confirmation {
    public String getConfirmation_number() {
        return confirmation_number;
    }

    public void setConfirmation_number(String confirmation_number) {
        this.confirmation_number = confirmation_number;
    }

    private String confirmation_number;

    public Confirmation() {
        this.confirmation_number = randomReserve();
    }

    private static String randomReserve() {
        double randomNumber = Math.random();
        return String.valueOf(randomNumber).replace("0.", "").substring(0,6);
    }
}
