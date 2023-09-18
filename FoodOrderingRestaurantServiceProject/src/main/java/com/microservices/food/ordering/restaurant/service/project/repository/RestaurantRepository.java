package com.microservices.food.ordering.restaurant.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.restaurant.service.project.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> 
{
	Restaurant findByRestaurantName(String restaurantname);
}
