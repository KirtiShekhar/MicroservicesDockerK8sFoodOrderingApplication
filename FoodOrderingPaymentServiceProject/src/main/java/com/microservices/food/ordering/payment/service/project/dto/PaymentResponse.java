package com.microservices.food.ordering.payment.service.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse 
{
	private Long paymentId;
	private Integer totalAmount;
	private Integer totalQuantity;
	private LocalDateTime createdTimestamp;
	private CreditCardInfoResponse creditCardInfoResponse;
}
