package com.microservices.food.ordering.order.service.projects.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "food_ordering_user_information")
public class UserInformation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_information_id",nullable = false)
	private Long userInformationId;
	@Column(name = "user_name",nullable = false)
	private String userName;
	@Column(name = "user_full_name",nullable = false)
	private String userFullName;
	@Column(name = "user_contact_number",nullable = false)
	private String contactNumber;
	@Column(name = "user_email_address",nullable = false)
	private String emailAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "permanent_address_information_id",referencedColumnName = "address_information_id")
	private AddressInformation userPermanentAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "correspondence_address_information_id",referencedColumnName = "address_information_id")
	private AddressInformation userCorrespondenceAddress;
}