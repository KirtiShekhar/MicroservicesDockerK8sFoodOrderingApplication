package com.microservices.food.ordering.order.service.projects.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest 
{
	private Long restaurantId;
	private String orderSpecialNote;
	private String delivaryNote;
	private BigDecimal totalAmount;
	private LocalDateTime orderCreatedTime;
	private LocalDateTime delivaryTime;
	private OrderLineItemsRequest orderLineItemsRequest;
	private UserInformationRequest userInfoRequest;
}
