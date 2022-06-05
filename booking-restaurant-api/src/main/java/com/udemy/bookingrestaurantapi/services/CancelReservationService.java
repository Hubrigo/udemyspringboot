package com.udemy.bookingrestaurantapi.services;

import com.udemy.bookingrestaurantapi.exceptions.BookingException;

public interface CancelReservationService {
	
	public String deleteReservation (String locator) throws BookingException;
	

}
