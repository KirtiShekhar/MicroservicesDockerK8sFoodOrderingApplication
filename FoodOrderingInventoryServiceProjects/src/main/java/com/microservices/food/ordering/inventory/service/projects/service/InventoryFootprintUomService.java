package com.microservices.food.ordering.inventory.service.projects.service;

import java.util.List;

import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemFootPrintRequest;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemFootPrintResponse;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemRequest;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemResponse;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryUnitOfMeasureRequest;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItem;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItemFootPrint;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryUnitOfMeasure;

public interface InventoryFootprintUomService {

	InventoryItemResponse findByInventoryFoodItemLpnNumber(String inventoryFoodItemLpnNumber);

	InventoryItemResponse findByInventoryFoodItemCategory(String inventoryFoodItemCategory);

	InventoryItemFootPrintResponse findByInventoryFoodItemFootprintName(String inventoryFoodItemFootprintName);

	List<InventoryUnitOfMeasure> findByInventoryFoodItemFootprintId(Long inventoryfooditemfootprintid);

	InventoryItem createNewItem(InventoryItemRequest inventoryItemRequest);

	InventoryItemFootPrint createNewItemFootPrint(InventoryItemFootPrintRequest inventoryItemFootPrintRequest);

	InventoryUnitOfMeasure createNewUnitOfMeasure(InventoryUnitOfMeasureRequest inventoryUnitOfMeasureRequest);

}
