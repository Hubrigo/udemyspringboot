package com.udemy.bookingrestaurantapi.services;

import java.util.List;

import com.udemy.bookingrestaurantapi.exceptions.BookingException;
import com.udemy.bookingrestaurantapi.jsons.RestaurantRest;

public interface RestaurantService {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

	public List<RestaurantRest> getRestaurants() throws BookingException;
}
