package com.microservices.food.ordering.order.service.projects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_ordering_address_information")
public class AddressInformation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_information_id",nullable = false)
	private Long addressInformationId;
	@Column(name = "address_line_1",nullable = false,columnDefinition = "text")
	private String addressLine1;
	@Column(name = "address_line_2",nullable = false,columnDefinition = "text")
	private String addressLine2;
	@Column(name = "address_city",nullable = false)
	private String city;
	@Column(name = "address_state",nullable = false)
	private String state;
	@Column(name = "address_zip_code",nullable = false)
	private String zipCode;
}
