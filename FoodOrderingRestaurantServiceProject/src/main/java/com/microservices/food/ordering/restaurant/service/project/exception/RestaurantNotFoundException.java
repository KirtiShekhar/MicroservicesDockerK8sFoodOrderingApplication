package com.microservices.food.ordering.restaurant.service.project.exception;

public class RestaurantNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;

	public RestaurantNotFoundException(String message) {
		super(message);
	}
}
