package com.microservices.food.ordering.order.service.projects.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsResponse 
{
	private Long orderLineItemsId;
	private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
