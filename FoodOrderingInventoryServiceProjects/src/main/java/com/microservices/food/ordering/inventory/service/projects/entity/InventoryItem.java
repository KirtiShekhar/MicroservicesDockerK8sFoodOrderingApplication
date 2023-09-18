package com.microservices.food.ordering.inventory.service.projects.entity;

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
@Table(name = "food_ordering_inventory_item")
public class InventoryItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_item_id",nullable = false)
	private Long inventoryFoodItemId;
	@Column(name = "inventory_item_lpn_number",nullable = false)
	private String inventoryFoodItemLpnNumber;
	@Column(name = "inventory_item_name",nullable = false)
	private String inventoryFoodItemName;
	@Column(name = "inventory_item_description",nullable = false,columnDefinition = "text")
	private String inventoryFoodItemDescription;
	@Column(name = "inventory_item_category",nullable = false)
	private String inventoryFoodItemCategory;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_item_footprint_id",referencedColumnName = "inventory_item_footprint_id")
	private InventoryItemFootPrint inventoryFoodItemFootprint;
}