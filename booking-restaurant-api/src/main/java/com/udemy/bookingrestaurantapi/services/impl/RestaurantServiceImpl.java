package com.udemy.bookingrestaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bookingrestaurantapi.entitys.Restaurant;
import com.udemy.bookingrestaurantapi.exceptions.BookingException;
import com.udemy.bookingrestaurantapi.exceptions.NotFoundException;
import com.udemy.bookingrestaurantapi.jsons.RestaurantRest;
import com.udemy.bookingrestaurantapi.repositories.RestaurantRepository;
import com.udemy.bookingrestaurantapi.services.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {

		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public List<RestaurantRest> getRestaurants() throws BookingException {
		
		final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
		
		
		return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
		
		return restaurantRepository.findAllById(restaurantId)
				.orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
	}

}
