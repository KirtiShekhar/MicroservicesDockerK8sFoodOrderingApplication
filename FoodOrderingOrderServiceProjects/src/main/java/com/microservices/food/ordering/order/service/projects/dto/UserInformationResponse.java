package com.microservices.food.ordering.order.service.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationResponse 
{
	private Long userInformationId;
	private String userName;
	private String userFullName;
	private String contactNumber;
	private String emailAddress;
	private AddressInformationResponse userPermanentAddressResponse;
	private AddressInformationResponse userCorrespondenceAddressResponse;
}
