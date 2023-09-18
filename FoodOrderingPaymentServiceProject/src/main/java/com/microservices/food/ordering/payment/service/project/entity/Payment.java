package com.microservices.food.ordering.payment.service.project.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

@Entity
@Table(name = "food_ordering_payment_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id",nullable = false)
	private Long paymentId;
	@Column(name = "total_amount",nullable = false)
	private Integer totalAmount;
	@Column(name = "total_quantity",nullable = false)
	private Integer totalQuantity;
	@CreationTimestamp
	@Column(name = "created_timestamp",nullable = false)
	private LocalDateTime createdTimestamp;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credit_card_info_id",referencedColumnName = "credit_card_info_id")
	private CreditCardInfo creditCardInfo;
}
