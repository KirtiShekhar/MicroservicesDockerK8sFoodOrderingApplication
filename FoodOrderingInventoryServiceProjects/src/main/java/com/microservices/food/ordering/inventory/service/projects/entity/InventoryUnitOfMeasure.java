package com.microservices.food.ordering.inventory.service.projects.entity;

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
@Table(name = "food_ordering_inventory_unit_of_measure")
public class InventoryUnitOfMeasure
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_fooditem_unit_of_measure_id",nullable = false)
	private Long inventoryFoodItemUnitOfMeasureId;
	@Column(name = "inventory_item_footprint_id",nullable = false)
	private Long inventoryFoodItemFootprintId;
	@Column(name = "inventory_fooditem_unit_of_measure_level",nullable = false)
	private Integer inventoryFoodItemUnitOfMeasureLevel;
	@Column(name = "inventory_fooditem_unit_of_measure_name",nullable = false)
	private String inventoryFoodItemUnitOfMeasureName;
	@Column(name = "inventory_fooditem_unit_of_measure_quantity",nullable = false,columnDefinition = "text")
	private String inventoryFoodItemUnitOfMeasureQuantity;
	@Column(name = "inventory_fooditem_unit_of_measure_netweight",nullable = false,columnDefinition = "text")
	private String inventoryFoodItemUnitOfMeasureNetWeight;
	@Column(name = "inventory_fooditem_unit_of_measure_grossweight",nullable = false,columnDefinition = "text")
	private String inventoryFoodItemUnitOfMeasureGrossWeight;
	@Column(name = "inventory_fooditem_unit_of_measure_dimensions_in_inches",nullable = false,columnDefinition = "text")
	private String inventoryFoodItemUnitOfMeasureDimensionsInInches;
}