package com.microservices.food.ordering.restaurant.service.project.mapper;

import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantRequest;
import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantResponse;
import com.microservices.food.ordering.restaurant.service.project.entity.Restaurant;

public class RestaurantMapper 
{
	public static Restaurant mapRestaurantRequestToRestaurant(RestaurantRequest restaurantRequest)
	{
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantName(restaurantRequest.getRestaurantName());
		restaurant.setRestaurantAddress(restaurantRequest.getRestaurantAddress());
		restaurant.setRestaurantDescription(restaurantRequest.getRestaurantDescription());
		return restaurant;
	}
	
	public static RestaurantResponse mapRestaurantToRestaurantResponse(Restaurant restaurant)
	{
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		restaurantResponse.setRestaurantId(restaurant.getRestaurantId());
		restaurantResponse.setRestaurantName(restaurant.getRestaurantName());
		restaurantResponse.setRestaurantAddress(restaurant.getRestaurantAddress());
		restaurantResponse.setRestaurantDescription(restaurant.getRestaurantDescription());
		return restaurantResponse;
	}
}