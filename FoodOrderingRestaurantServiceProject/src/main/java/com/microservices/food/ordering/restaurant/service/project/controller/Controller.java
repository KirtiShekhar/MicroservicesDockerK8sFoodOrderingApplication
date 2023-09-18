package com.microservices.food.ordering.restaurant.service.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.food.ordering.restaurant.service.project.dto.FoodMenuItemRequest;
import com.microservices.food.ordering.restaurant.service.project.dto.FoodMenuItemResponse;
import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantRequest;
import com.microservices.food.ordering.restaurant.service.project.dto.RestaurantResponse;
import com.microservices.food.ordering.restaurant.service.project.entity.FoodMenuItem;
import com.microservices.food.ordering.restaurant.service.project.entity.Restaurant;
import com.microservices.food.ordering.restaurant.service.project.service.Service;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/restaurant")
public class Controller 
{
	Logger restaurantAndFoodMenuItemControllerLogger = LoggerFactory.getLogger(RestaurantAndFoodMenuItemController.class);
	
	@Autowired
	private Service service;
	
	@PostMapping("save")
	@Operation(summary = "Save new Restaurant to the database")
	public ResponseEntity<?> createRestaurant(@RequestBody RestaurantRequest restaurantRequest)
	{
		restaurantAndFoodMenuItemControllerLogger.info("Save new Restaurant to the database");
		Restaurant restaurant = service.createRestaurant(restaurantRequest);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.CREATED);
	}
	
	@GetMapping("getByName")
	@Operation(summary = "find restaurant by given restaurant name from the database")
	public ResponseEntity<?> findRestaurantByRestaurantName(@RequestParam String restaurantname)
	{
		restaurantAndFoodMenuItemControllerLogger.info("find restaurant by given restaurant name from the database");
		RestaurantResponse restaurantResponse = service.findRestaurantByRestaurantName(restaurantname);
		return new ResponseEntity<RestaurantResponse>(restaurantResponse,HttpStatus.OK);
	}
	
	@PostMapping("foodmenuitem/save")
	@Operation(summary = "Save new MenuItem to the database")
	public  ResponseEntity<?> createMenuItem(@RequestBody FoodMenuItemRequest foodMenuItemRequest)
	{
		restaurantAndFoodMenuItemControllerLogger.info("Save new MenuItem to the database");
		FoodMenuItem foodMenuItem = service.createMenuItem(foodMenuItemRequest);
		return new ResponseEntity<FoodMenuItem>(foodMenuItem,HttpStatus.CREATED);
	}
	
	@GetMapping("foodmenuitem/getByItemName")
	@Operation(summary = "find food menu item by given item name from the database")
	public ResponseEntity<?> findMenuItemByFoodMenuItemName(@RequestParam String foodmenuitemname)
	{
		restaurantAndFoodMenuItemControllerLogger.info("find food menu item by given item name from the database");
		FoodMenuItemResponse foodMenuItemResponse = service.findMenuItemByFoodMenuItemName(foodmenuitemname);
		return new ResponseEntity<FoodMenuItemResponse>(foodMenuItemResponse,HttpStatus.OK);
	}
	
	@GetMapping("foodmenuitem/getByRestaurantId")
	@Operation(summary = "find food menu item by given restaurant id from the database")
	public ResponseEntity<?> findMenuItemByRestaurantId(@RequestParam Long restaurantid)
	{
		restaurantAndFoodMenuItemControllerLogger.info("find food menu item by given restaurant id from the database");
		List<FoodMenuItem> foodMenuItemList = service.findMenuItemByRestaurantId(restaurantid);
		return new ResponseEntity<List<FoodMenuItem>>(foodMenuItemList,HttpStatus.OK);
	}
}
