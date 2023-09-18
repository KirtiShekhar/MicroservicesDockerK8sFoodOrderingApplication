package com.microservices.food.ordering.inventory.service.projects.exception;

public class InventoryItemNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;
	
	public InventoryItemNotFoundException(String message)
	{
		super(message);
	}
}