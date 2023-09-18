package com.microservices.food.ordering.restaurant.service.project.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse 
{
	private String message;
	private int statusCode;
	private LocalDateTime errorDateTime;
}
