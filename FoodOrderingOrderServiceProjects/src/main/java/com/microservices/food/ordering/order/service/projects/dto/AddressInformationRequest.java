package com.microservices.food.ordering.order.service.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressInformationRequest 
{
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
}
