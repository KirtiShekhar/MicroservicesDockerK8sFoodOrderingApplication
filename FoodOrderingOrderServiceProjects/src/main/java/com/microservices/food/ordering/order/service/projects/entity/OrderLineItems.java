package com.microservices.food.ordering.order.service.projects.entity;

import java.math.BigDecimal;

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
@Table(name = "food_ordering_order_line_items")
public class OrderLineItems 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_line_items_id",nullable = false)
	private Long orderLineItemsId;
	@Column(name = "sku_code",nullable = false)
	private String skuCode;
	@Column(name = "item_price",nullable = false)
    private BigDecimal price;
	@Column(name = "item_quantity",nullable = false)
    private Integer quantity;
}
