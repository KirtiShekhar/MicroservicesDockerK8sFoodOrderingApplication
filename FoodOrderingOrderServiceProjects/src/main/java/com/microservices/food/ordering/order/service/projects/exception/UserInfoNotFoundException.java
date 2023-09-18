package com.microservices.food.ordering.order.service.projects.exception;

public class UserInfoNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;
	
	public UserInfoNotFoundException(String message)
	{
		super(message);
	}
}