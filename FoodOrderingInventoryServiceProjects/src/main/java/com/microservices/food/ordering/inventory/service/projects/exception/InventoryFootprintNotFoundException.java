package com.microservices.food.ordering.inventory.service.projects.exception;

public class InventoryFootprintNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;
	
	public InventoryFootprintNotFoundException(String message)
	{
		super(message);
	}
}