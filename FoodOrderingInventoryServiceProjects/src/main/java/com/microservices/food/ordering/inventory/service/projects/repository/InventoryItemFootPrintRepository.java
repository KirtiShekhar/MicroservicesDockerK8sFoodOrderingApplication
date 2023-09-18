package com.microservices.food.ordering.inventory.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItemFootPrint;

@Repository
public interface InventoryItemFootPrintRepository extends JpaRepository<InventoryItemFootPrint, Long> 
{
	InventoryItemFootPrint findByInventoryFoodItemFootprintName(String inventoryFoodItemFootprintName);
}
