package com.microservices.food.ordering.order.service.projects.entity;

import java.math.BigDecimal;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_ordering_orders_service")
public class Orders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id",nullable = false)
	private Long orderId;
	@Column(name = "restaurant_id",nullable = false)
	private Long restaurantId;
	@Column(name = "order_special_note",nullable = false,columnDefinition = "text")
	private String orderSpecialNote;
	@Column(name = "delivery_note",nullable = false,columnDefinition = "text")
	private String delivaryNote;
	@Column(name = "total_amount",nullable = false)
	private BigDecimal totalAmount;
	@Column(name = "order_created_time",nullable = false)
	@CreationTimestamp
	private LocalDateTime orderCreatedTime;
	@Column(name = "delivery_time",nullable = false)
	@CreationTimestamp
	private LocalDateTime delivaryTime;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_line_items_id",referencedColumnName = "order_line_items_id")
	private OrderLineItems orderLineItems;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_information_id",referencedColumnName = "user_information_id")
	private UserInformation userInfo;
}