package com.microservices.food.ordering.restaurant.service.project.mapper;

import com.microservices.food.ordering.restaurant.service.project.dto.FoodMenuItemResponse;
import com.microservices.food.ordering.restaurant.service.project.dto.FoodMenuItemRequest;
import com.microservices.food.ordering.restaurant.service.project.entity.FoodMenuItem;

public class FoodMenuItemMapper 
{
	public static FoodMenuItem mapFoodMenuItemRequestToFoodMenuItem(FoodMenuItemRequest foodMenuItemRequest)
	{
		FoodMenuItem foodMenuItem = new FoodMenuItem();
		foodMenuItem.setRestaurantId(foodMenuItemRequest.getRestaurantId());
		foodMenuItem.setFoodMenuItemName(foodMenuItemRequest.getFoodMenuItemName());
		foodMenuItem.setFoodMenuItemDescription(foodMenuItemRequest.getFoodMenuItemDescription());
		foodMenuItem.setFoodMenuItemPrice(foodMenuItemRequest.getFoodMenuItemPrice());
		foodMenuItem.setFoodMenuItemQuantity(foodMenuItemRequest.getFoodMenuItemQuantity());
		return foodMenuItem;
	}
	
	public static FoodMenuItemResponse mapFoodMenuItemToFoodMenuItemResponse(FoodMenuItem foodMenuItem)
	{
		FoodMenuItemResponse foodMenuItemResponse = new FoodMenuItemResponse();
		foodMenuItemResponse.setFoodMenuItemId(foodMenuItem.getFoodMenuItemId());
		foodMenuItemResponse.setRestaurantId(foodMenuItem.getRestaurantId());
		foodMenuItemResponse.setFoodMenuItemName(foodMenuItem.getFoodMenuItemName());
		foodMenuItemResponse.setFoodMenuItemDescription(foodMenuItem.getFoodMenuItemDescription());
		foodMenuItemResponse.setFoodMenuItemPrice(foodMenuItem.getFoodMenuItemPrice());
		foodMenuItemResponse.setFoodMenuItemQuantity(foodMenuItem.getFoodMenuItemQuantity());
		return foodMenuItemResponse;
	}
}