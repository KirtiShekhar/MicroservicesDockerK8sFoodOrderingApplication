package com.microservices.food.ordering.restaurant.service.project.entity;

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
@Table(name = "food_ordering_restaurant_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_Id",nullable = false)
	private Long restaurantId;
	@Column(name = "restaurant_name",nullable = false)
	private String restaurantName;
	@Column(name = "restaurant_Description",nullable = false,columnDefinition = "Text")
	private String restaurantDescription;
	@Column(name = "restaurant_Address",nullable = false,columnDefinition = "Text")
	private String restaurantAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_menu_item_Id",referencedColumnName = "food_menu_item_Id")
	private FoodMenuItem foodMenuItem;
}
