package com.microservices.food.ordering.restaurant.service.project.exception;

public class FoodMenuItemNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;

	public FoodMenuItemNotFoundException(String message) {
		super(message);
	}
}
