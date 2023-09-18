package com.microservices.food.ordering.inventory.service.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemFootPrintResponse
{
	private Long inventoryFoodItemFootprintId;
	private String inventoryFoodItemFootprintName;
	private String inventoryFoodItemFootprintDescription;
	private String inventoryFoodItemFootprintReceivingUOM;
	private InventoryUnitOfMeasureResponse inventoryUnitOfMeasureResponse;
}
