package com.microservices.food.ordering.restaurant.service.project.service;

import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantRequest;
import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantResponse;
import com.microservices.food.ordering.restaurant.service.project.entity.Restaurant;

public interface Service {

	RestaurantResponse findRestaurantByRestaurantName(String restaurantname);

	Restaurant createRestaurant(RestaurantRequest restaurantRequest);

	List<FoodMenuItem> findMenuItemByRestaurantId(Long restaurantid);

	FoodMenuItemResponse findMenuItemByFoodMenuItemName(String foodmenuitemname);

	FoodMenuItem createMenuItem(FoodMenuItemRequest foodMenuItemRequest);

}
