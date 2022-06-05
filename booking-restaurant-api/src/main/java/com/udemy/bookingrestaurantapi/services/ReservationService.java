package com.udemy.bookingrestaurantapi.services;

import com.udemy.bookingrestaurantapi.exceptions.BookingException;
import com.udemy.bookingrestaurantapi.jsons.CreateReservationRest;
import com.udemy.bookingrestaurantapi.jsons.ReservationRest;

public interface ReservationService {
	
	ReservationRest getReservation(Long reservationId) throws BookingException;
	
	String createReservation(CreateReservationRest createReservationRest) throws BookingException;

}
