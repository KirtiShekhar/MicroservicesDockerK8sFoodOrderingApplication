package com.microservices.food.ordering.restaurant.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest 
{
	private String restaurantName;
	private String restaurantDescription;
	private String restaurantAddress;
}
