package com.microservices.food.ordering.restaurant.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.restaurant.service.project.entity.FoodMenuItem;
import java.lang.Long;
import java.util.List;
import java.lang.String;

@Repository
public interface FoodMenuItemRepository extends JpaRepository<FoodMenuItem, Long> 
{
	List<FoodMenuItem> findByRestaurantId(Long restaurantid);
	
	FoodMenuItem findByFoodMenuItemName(String foodmenuitemname);

}
