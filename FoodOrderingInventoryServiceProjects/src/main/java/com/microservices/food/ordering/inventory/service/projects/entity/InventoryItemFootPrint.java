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
@Table(name = "food_ordering_inventory_item_footprint")
public class InventoryItemFootPrint 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_item_footprint_id",nullable = false)
	private Long inventoryFoodItemFootprintId;
	@Column(name = "inventory_item_footprint_name",nullable = false)
	private String inventoryFoodItemFootprintName;
	@Column(name = "inventory_item_footprint_description",nullable = false,columnDefinition = "text")
	private String inventoryFoodItemFootprintDescription;
	@Column(name = "inventory_item_footprint_receiving_unit_of_measure",nullable = false)
	private String inventoryFoodItemFootprintReceivingUOM;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_fooditem_unit_of_measure_id")
	private InventoryUnitOfMeasure inventoryFoodItemUnitOfMeasure;
}
