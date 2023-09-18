package com.microservices.food.ordering.restaurant.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenuItemRequest 
{
	private Long restaurantId;
	private String foodMenuItemName;
	private String foodMenuItemDescription;
	private Integer foodMenuItemPrice;
	private Integer foodMenuItemQuantity;
}