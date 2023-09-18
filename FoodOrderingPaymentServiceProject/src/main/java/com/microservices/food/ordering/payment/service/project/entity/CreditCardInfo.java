package com.microservices.food.ordering.payment.service.project.entity;

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

@Entity
@Table(name = "food_ordering_credit_card_deatls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credit_card_info_id",nullable = false)
	private Long creditCardInfoId;
	@Column(name = "credit_card_holder_name",nullable = false)
	private String creditCardHolderName;
	@Column(name = "credit_card_number",nullable = false)
	private Long creditCardNumber;
	@Column(name = "credit_card_expired_month",nullable = false)
	private Integer creditCardExpiredMonth;	
	@Column(name = "credit_card_expired_year",nullable = false)
	private Integer creditCardExpiredYear;	
	@Column(name = "credit_card_security_code",nullable = false)
	private Integer creditCardSecurityCode;	
}
