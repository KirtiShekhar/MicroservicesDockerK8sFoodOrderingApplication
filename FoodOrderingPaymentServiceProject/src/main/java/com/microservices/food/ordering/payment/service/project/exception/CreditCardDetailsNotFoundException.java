package com.microservices.food.ordering.payment.service.project.exception;

public class CreditCardDetailsNotFoundException extends RuntimeException
{
	private static final long serialVersionUID=1L;
	
	public CreditCardDetailsNotFoundException(String message)
	{
		super(message);
	}
}