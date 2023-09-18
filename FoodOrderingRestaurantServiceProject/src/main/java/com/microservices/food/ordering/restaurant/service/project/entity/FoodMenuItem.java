package com.microservices.food.ordering.restaurant.service.project.entity;

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
@Table(name = "food_ordering_food_menu_items")
public class FoodMenuItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_menu_item_Id",nullable = false)
	private Long foodMenuItemId;
	@Column(name = "restaurant_Id",nullable = false)
	private Long restaurantId;
	@Column(name = "food_menu_item_Name",nullable = false)
	private String foodMenuItemName;
	@Column(name = "food_menu_item_Description",nullable = false,columnDefinition = "Text")
	private String foodMenuItemDescription;
	@Column(name = "food_menu_item_Price",nullable = false)
	private Integer foodMenuItemPrice;
	@Column(name = "food_menu_item_Quantity",nullable = false)
	private Integer foodMenuItemQuantity;
}
