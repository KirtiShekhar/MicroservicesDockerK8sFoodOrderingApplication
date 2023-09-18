package com.microservices.food.ordering.inventory.service.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryUnitOfMeasureRequest
{
	private Long inventoryFoodItemFootprintId;
	private Integer inventoryFoodItemUnitOfMeasureLevel;
	private String inventoryFoodItemUnitOfMeasureName;
	private String inventoryFoodItemUnitOfMeasureQuantity;
	private String inventoryFoodItemUnitOfMeasureNetWeight;
	private String inventoryFoodItemUnitOfMeasureGrossWeight;
	private String inventoryFoodItemUnitOfMeasureDimensionsInInches;
}
