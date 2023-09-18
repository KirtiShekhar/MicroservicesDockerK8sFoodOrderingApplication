package com.microservices.food.ordering.payment.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardInfoResponse 
{
	private Long creditCardInfoId;
	private String creditCardHolderName;
	private Long creditCardNumber;
	private Integer creditCardExpiredMonth;	
	private Integer creditCardExpiredYear;	
	private Integer creditCardSecurityCode;
}
