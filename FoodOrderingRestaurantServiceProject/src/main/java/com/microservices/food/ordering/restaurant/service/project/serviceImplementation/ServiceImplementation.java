package com.microservices.food.ordering.restaurant.service.project.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantRequest;
import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantResponse;
import com.microservices.food.ordering.restaurant.service.project.entity.Restaurant;
import com.microservices.food.ordering.restaurant.service.project.exception.RestaurantNotFoundException;
import com.microservices.food.ordering.restaurant.service.project.mapper.RestaurantMapper;
import com.microservices.food.ordering.restaurant.service.project.repository.RestaurantRepository;
import com.microservices.food.ordering.restaurant.service.project.service.RestaurantService;

@Service
public class ServiceImplementation implements Service
{
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private FoodMenuItemRepository foodMenuItemRepository;
	
	@Override
	public Restaurant createRestaurant(RestaurantRequest restaurantRequest)
	{
		Restaurant restaurant = RestaurantMapper.mapRestaurantRequestToRestaurant(restaurantRequest);
		Restaurant savedRestaurant = restaurantRepository.save(restaurant);
		return savedRestaurant;
	}
	
	@Override
	public RestaurantResponse findRestaurantByRestaurantName(String restaurantname)
	{
		Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantname);
		if(restaurant == null)
		{
			throw new RestaurantNotFoundException("Restaurant with given name not found in the database");
		}
		RestaurantResponse restaurantResponse = RestaurantMapper.mapRestaurantToRestaurantResponse(restaurant);
		return restaurantResponse;
	}

	@Override
	public FoodMenuItem createMenuItem(FoodMenuItemRequest foodMenuItemRequest)
	{
		FoodMenuItem foodMenuItem = FoodMenuItemMapper.mapFoodMenuItemRequestToFoodMenuItem(foodMenuItemRequest);
		FoodMenuItem savedFoodMenuItem = foodMenuItemRepository.save(foodMenuItem);
		return savedFoodMenuItem;
	}
	
	@Override
	public FoodMenuItemResponse findMenuItemByFoodMenuItemName(String foodmenuitemname)
	{
		FoodMenuItem foodMenuItem = foodMenuItemRepository.findByFoodMenuItemName(foodmenuitemname);
		if(foodMenuItem == null)
		{
			throw new FoodMenuItemNotFoundException("Food item with given name not found in the database");
		}
		FoodMenuItemResponse foodMenuItemResponse = FoodMenuItemMapper.mapFoodMenuItemToFoodMenuItemResponse(foodMenuItem);
		return foodMenuItemResponse;
	}
	
	@Override
	public List<FoodMenuItem> findMenuItemByRestaurantId(Long restaurantid)
	{
		return foodMenuItemRepository.findByRestaurantId(restaurantid);
	}
}
