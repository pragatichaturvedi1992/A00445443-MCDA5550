package com.example.HotelReservation.entities;

import java.util.List;

public class ReservationDetails {
    private String hotel_name;
    private String checkin;
    private String checkout;
    private List<Guest> guest_list;

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public List<Guest> getGuest_list() {
        return guest_list;
    }

    public void setGuest_list(List<Guest> guest_list) {
        this.guest_list = guest_list;
    }
}
