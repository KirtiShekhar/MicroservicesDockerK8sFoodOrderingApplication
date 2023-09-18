package com.microservices.food.ordering.inventory.service.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemResponse 
{
	private Long inventoryFoodItemId;
	private String inventoryFoodItemLpnNumber;
	private String inventoryFoodItemName;
	private String inventoryFoodItemDescription;
	private String inventoryFoodItemCategory;
	private InventoryItemFootPrintResponse inventoryFoodItemFootprintResponse;
}