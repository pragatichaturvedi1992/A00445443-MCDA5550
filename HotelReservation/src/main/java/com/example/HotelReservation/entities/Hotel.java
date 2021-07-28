package com.example.HotelReservation.entities;

import java.util.ArrayList;
import java.util.List;

public class Hotel {


	private List<Reservation> reservations;

	private final long id;
	private final String hotelName;

	public Hotel(long id, String hotelName) {
		this.id = id;
		this.hotelName = hotelName;
		this.reservations = new ArrayList<Reservation>();
		Reservation reservation = new Reservation();
		reservation.setReservationID(23);
		this.reservations.add(reservation);
	}

	public long getId() {
		return id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	void setReservation(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
