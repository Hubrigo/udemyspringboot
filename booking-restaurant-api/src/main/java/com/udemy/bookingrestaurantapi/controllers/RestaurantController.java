package com.udemy.bookingrestaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.bookingrestaurantapi.exceptions.BookingException;
import com.udemy.bookingrestaurantapi.jsons.RestaurantRest;
import com.udemy.bookingrestaurantapi.responses.BookingResponse;
import com.udemy.bookingrestaurantapi.services.RestaurantService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "v1")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "restaurant" + "/{" + "restaurantId"+ "}", 
		method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingException {

		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}

}
