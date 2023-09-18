package com.microservices.food.ordering.inventory.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.inventory.service.projects.entity.InventoryUnitOfMeasure;
import java.lang.Long;
import java.util.List;

@Repository
public interface InventoryUnitOfMeasureRepository extends JpaRepository<InventoryUnitOfMeasure, Long> 
{
	List<InventoryUnitOfMeasure> findByInventoryFoodItemFootprintId(Long inventoryfooditemfootprintid);
}
