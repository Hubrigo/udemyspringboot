package com.udemy.bookingrestaurantapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udemy.bookingrestaurantapi.entitys.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	Optional<Restaurant> findAllById(Long id);
	
	Optional<Restaurant> findAllByName(String nameRestaurant);
	
	@Query("SELECT REST FROM Restaurant REST")
	public List<Restaurant> findRestaurants();

}
