package com.udemy.bookingrestaurantapi.services.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.udemy.bookingrestaurantapi.entitys.Reservation;
import com.udemy.bookingrestaurantapi.entitys.Restaurant;
import com.udemy.bookingrestaurantapi.entitys.Turn;
import com.udemy.bookingrestaurantapi.exceptions.BookingException;
import com.udemy.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.udemy.bookingrestaurantapi.exceptions.NotFoundException;
import com.udemy.bookingrestaurantapi.jsons.CreateReservationRest;
import com.udemy.bookingrestaurantapi.jsons.ReservationRest;
import com.udemy.bookingrestaurantapi.repositories.ReservationRepository;
import com.udemy.bookingrestaurantapi.repositories.RestaurantRepository;
import com.udemy.bookingrestaurantapi.repositories.TurnRepository;
import com.udemy.bookingrestaurantapi.services.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private TurnRepository turnRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public ReservationRest getReservation(Long reservationId) throws BookingException {

		return modelMapper.map(getReservationEntity(reservationId), ReservationRest.class);
	}

	public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

		final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));
		
		final Turn turnid = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));

		String locator = gerateLocator(restaurantId, createReservationRest);

		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turnid.getName());
		
		try {
			
			reservationRepository.save(reservation);
			
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR",e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
			
		}
		
		
		return null;
	}

	private String gerateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingException {

		return restaurantId.getName() + createReservationRest.getTurnId();
	}

	private Reservation getReservationEntity(Long reservationId) throws BookingException {

		return reservationRepository.findById(reservationId)
				.orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESERVATION_NOT_FOUND"));

	}

}
