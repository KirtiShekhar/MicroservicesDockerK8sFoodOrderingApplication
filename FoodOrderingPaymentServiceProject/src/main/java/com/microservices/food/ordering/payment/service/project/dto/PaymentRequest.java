package com.microservices.food.ordering.payment.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest 
{
	private Integer totalAmount;
	private Integer totalQuantity;
	private CreditCardInfoRequest creditCardInfoRequest;
}
