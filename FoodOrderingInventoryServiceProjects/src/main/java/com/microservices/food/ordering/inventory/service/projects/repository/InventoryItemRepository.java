package com.microservices.food.ordering.inventory.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItem;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> 
{
	InventoryItem findByInventoryFoodItemCategory(String inventoryFoodItemCategory);
	InventoryItem findByInventoryFoodItemLpnNumber(String inventoryFoodItemLpnNumber);
}
