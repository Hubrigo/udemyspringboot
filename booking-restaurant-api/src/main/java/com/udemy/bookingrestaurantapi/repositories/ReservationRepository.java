package com.udemy.bookingrestaurantapi.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.udemy.bookingrestaurantapi.entitys.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	Optional<Reservation> findById(Long id);
	
	Optional<Reservation> findBylocator(String locator);
	
	@Modifying
	@Transactional
	Optional<Reservation> deleteBylocator(String locator);
	
	Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);
	
}
