package com.microservices.food.ordering.inventory.service.projects.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemFootPrintResponse;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemRequest;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemResponse;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItem;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryUnitOfMeasure;
import com.microservices.food.ordering.inventory.service.projects.service.InventoryFootprintUomService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/inventory")
public class InventoryFootprintUomController 
{
	final static Logger inventoryControllerLogger = LoggerFactory.getLogger(InventoryFootprintUomController.class);
	
	@Autowired
	private InventoryFootprintUomService inventoryFootprintUomService;
	
	@PostMapping("item/footprint/uom/save")
	@Operation(summary = "save new item with footprint and unit of measure in database")
	public ResponseEntity<?> createNewItem(InventoryItemRequest inventoryItemRequest)
	{
		inventoryControllerLogger.info("save new item with footprint and unit of measure in database -- controller");
		InventoryItem savedInventoryItem = inventoryFootprintUomService.createNewItem(inventoryItemRequest);
		return new ResponseEntity<InventoryItem>(savedInventoryItem,HttpStatus.CREATED);
	}
	
	@GetMapping("footprint/uom/getListOfUOM")
	@Operation(summary = "get list of all UOM from database")
	public ResponseEntity<?> findByInventoryFoodItemFootprintId(@RequestParam Long inventoryfooditemfootprintid)
	{
		inventoryControllerLogger.info("get list of all UOM from database -- controller");
		List<InventoryUnitOfMeasure> inventoryFootprintUomList = inventoryFootprintUomService.findByInventoryFoodItemFootprintId(inventoryfooditemfootprintid);
		return new ResponseEntity<List<InventoryUnitOfMeasure>>(inventoryFootprintUomList,HttpStatus.OK);
	}
	
	@GetMapping("footprint/getByName")
	@Operation(summary = "get footprint of iem by given name from database")
	public ResponseEntity<?> findByInventoryFoodItemFootprintName(@RequestParam String inventoryFoodItemFootprintName)
	{
		inventoryControllerLogger.info("get footprint of iem by given name from database -- controller");
		InventoryItemFootPrintResponse inventoryItemFootPrintResponse = inventoryFootprintUomService.findByInventoryFoodItemFootprintName(inventoryFoodItemFootprintName);
		return new ResponseEntity<InventoryItemFootPrintResponse>(inventoryItemFootPrintResponse,HttpStatus.OK);
	}
	
	@GetMapping("item/getByCategory")
	@Operation(summary = "get iem by given category from database")
	public ResponseEntity<?> findByInventoryFoodItemCategory(@RequestParam String inventoryFoodItemCategory)
	{
		inventoryControllerLogger.info("get iem by given category from database -- controller");
		InventoryItemResponse inventoryItemResponse = inventoryFootprintUomService.findByInventoryFoodItemCategory(inventoryFoodItemCategory);
		return new ResponseEntity<InventoryItemResponse>(inventoryItemResponse,HttpStatus.OK);
	}
	
	@GetMapping("item/getByLPN")
	@Operation(summary = "get item by given lpn number from database")
	public ResponseEntity<?> findByInventoryFoodItemLpnNumber(@RequestParam String inventoryFoodItemLpnNumber)
	{
		inventoryControllerLogger.info("get item by given lpn number from database -- controller");
		InventoryItemResponse inventoryItemResponse = inventoryFootprintUomService.findByInventoryFoodItemCategory(inventoryFoodItemLpnNumber);
		return new ResponseEntity<InventoryItemResponse>(inventoryItemResponse,HttpStatus.OK);
	}
}