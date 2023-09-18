package com.microservices.food.ordering.payment.service.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(PaymentDetailsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePaymentDetailsNotFoundError(PaymentDetailsNotFoundException pdnfe)
	{
		ErrorResponse paymentErrorResponse = new ErrorResponse();
		paymentErrorResponse.setMessage(pdnfe.getMessage());
		paymentErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		paymentErrorResponse.setErrorDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(paymentErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CreditCardDetailsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCreditCardDetailsNotFoundError(CreditCardDetailsNotFoundException ccdnfe)
	{
		ErrorResponse paymentErrorResponse = new ErrorResponse();
		paymentErrorResponse.setMessage(ccdnfe.getMessage());
		paymentErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		paymentErrorResponse.setErrorDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(paymentErrorResponse,HttpStatus.NOT_FOUND);
	}

}
