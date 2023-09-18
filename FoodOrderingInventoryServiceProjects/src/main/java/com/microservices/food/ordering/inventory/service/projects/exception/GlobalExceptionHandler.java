package com.microservices.food.ordering.inventory.service.projects.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(InventoryItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInventoryItemNotFoundError(InventoryItemNotFoundException iinfe)
	{
		ErrorResponse inventoryNotFoundErrorResponse = new ErrorResponse();
		inventoryNotFoundErrorResponse.setMessage(iinfe.getMessage());
		inventoryNotFoundErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		inventoryNotFoundErrorResponse.setErrorDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(inventoryNotFoundErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InventoryFootprintNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInventoryFootprintNotFoundError(InventoryFootprintNotFoundException ifnfe)
	{
		ErrorResponse inventoryNotFoundErrorResponse = new ErrorResponse();
		inventoryNotFoundErrorResponse.setMessage(ifnfe.getMessage());
		inventoryNotFoundErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		inventoryNotFoundErrorResponse.setErrorDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(inventoryNotFoundErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InventoryUnitOfMeasureNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInventoryUnitOfMeasureNotFoundError(InventoryUnitOfMeasureNotFoundException iuomnfe)
	{
		ErrorResponse inventoryNotFoundErrorResponse = new ErrorResponse();
		inventoryNotFoundErrorResponse.setMessage(iuomnfe.getMessage());
		inventoryNotFoundErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		inventoryNotFoundErrorResponse.setErrorDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(inventoryNotFoundErrorResponse,HttpStatus.NOT_FOUND);
	}

}
