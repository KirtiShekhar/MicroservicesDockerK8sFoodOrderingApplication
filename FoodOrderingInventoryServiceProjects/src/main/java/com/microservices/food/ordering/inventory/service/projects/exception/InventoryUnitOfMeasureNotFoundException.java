package com.microservices.food.ordering.inventory.service.projects.exception;

public class InventoryUnitOfMeasureNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;
	
	public InventoryUnitOfMeasureNotFoundException(String message)
	{
		super(message);
	}
}