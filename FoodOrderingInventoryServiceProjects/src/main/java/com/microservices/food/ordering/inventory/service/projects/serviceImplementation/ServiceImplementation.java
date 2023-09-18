package com.microservices.food.ordering.inventory.service.projects.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.food.ordering.inventory.service.projects.repository.InventoryItemRepository;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemFootPrintRequest;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemFootPrintResponse;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemRequest;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryItemResponse;
import com.microservices.food.ordering.inventory.service.projects.dto.InventoryUnitOfMeasureRequest;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItem;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryItemFootPrint;
import com.microservices.food.ordering.inventory.service.projects.entity.InventoryUnitOfMeasure;
import com.microservices.food.ordering.inventory.service.projects.exception.InventoryFootprintNotFoundException;
import com.microservices.food.ordering.inventory.service.projects.exception.InventoryItemNotFoundException;
import com.microservices.food.ordering.inventory.service.projects.exception.InventoryUnitOfMeasureNotFoundException;
import com.microservices.food.ordering.inventory.service.projects.mapper.InventoryFootprintUomMapper;
import com.microservices.food.ordering.inventory.service.projects.repository.InventoryItemFootPrintRepository;
import com.microservices.food.ordering.inventory.service.projects.repository.InventoryUnitOfMeasureRepository;
import com.microservices.food.ordering.inventory.service.projects.service.InventoryFootprintUomService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ServiceImplementation implements InventoryFootprintUomService
{
	final static Logger inventoryServiceImplLogger = LoggerFactory.getLogger(InventoryFootprintUomServiceImplementation.class);
	
	@Autowired
	private InventoryItemRepository inventoryItemRepository;
	
	@Autowired
	private InventoryItemFootPrintRepository inventoryItemFootPrintRepository;
	
	@Autowired
	private InventoryUnitOfMeasureRepository inventoryUnitOfMeasureRepository;
	
	@Override
	public InventoryUnitOfMeasure createNewUnitOfMeasure(InventoryUnitOfMeasureRequest inventoryUnitOfMeasureRequest)
	{
		inventoryServiceImplLogger.info("save new unit of measure in database -- service");
		InventoryUnitOfMeasure inventoryUnitOfMeasure = InventoryFootprintUomMapper.mapInventoryUnitOfMeasureRequestToInventoryUnitOfMeasure(inventoryUnitOfMeasureRequest);
		InventoryUnitOfMeasure savedInventoryUnitOfMeasure = inventoryUnitOfMeasureRepository.save(inventoryUnitOfMeasure);
		return savedInventoryUnitOfMeasure;
	}
	
	@Override
	public InventoryItemFootPrint createNewItemFootPrint(InventoryItemFootPrintRequest inventoryItemFootPrintRequest)
	{
		inventoryServiceImplLogger.info("save new footprint for the item in database -- service");
		createNewUnitOfMeasure(inventoryItemFootPrintRequest.getInventoryUnitOfMeasureRequest());
		InventoryItemFootPrint inventoryItemFootPrint = InventoryFootprintUomMapper.mapInventoryItemFootPrintRequestToInventoryItemFootPrint(inventoryItemFootPrintRequest);
		InventoryItemFootPrint savedInventoryItemFootPrint = inventoryItemFootPrintRepository.save(inventoryItemFootPrint);
		return savedInventoryItemFootPrint;
	}
	
	@Override
	public InventoryItem createNewItem(InventoryItemRequest inventoryItemRequest)
	{
		inventoryServiceImplLogger.info("save new item in database -- service");
		createNewItemFootPrint(inventoryItemRequest.getInventoryFoodItemFootprintRequest());
		InventoryItem inventoryItem = InventoryFootprintUomMapper.mapInventoryItemRequestToInventoryItem(inventoryItemRequest);
		InventoryItem savedInventoryItem = inventoryItemRepository.save(inventoryItem);
		return savedInventoryItem;
	}
	
	@Override
	public List<InventoryUnitOfMeasure> findByInventoryFoodItemFootprintId(Long inventoryfooditemfootprintid)
	{
		inventoryServiceImplLogger.info("get list of all UOM from database -- service");
		List<InventoryUnitOfMeasure> inventoryUnitOfMeasureList = inventoryUnitOfMeasureRepository.findByInventoryFoodItemFootprintId(inventoryfooditemfootprintid);
		if(inventoryUnitOfMeasureList.isEmpty())
		{
			throw new InventoryUnitOfMeasureNotFoundException("No List of measures found for given footprint id");
		}
		return inventoryUnitOfMeasureList;
	}
	
	@Override
	public InventoryItemFootPrintResponse findByInventoryFoodItemFootprintName(String inventoryFoodItemFootprintName)
	{
		inventoryServiceImplLogger.info("get footprint of iem by given name from database -- service");
		InventoryItemFootPrint  inventoryItemFootPrint = inventoryItemFootPrintRepository.findByInventoryFoodItemFootprintName(inventoryFoodItemFootprintName);
		if(inventoryItemFootPrint == null)
		{
			throw new InventoryFootprintNotFoundException("Footprint for given name not found");
		}
		InventoryItemFootPrintResponse fetchedInventoryItemFootPrintResponse = InventoryFootprintUomMapper.mapInventoryItemFootPrintToInventoryItemFootPrintResponse(inventoryItemFootPrint);
		return fetchedInventoryItemFootPrintResponse;
	}
	
	@Override
	public InventoryItemResponse findByInventoryFoodItemCategory(String inventoryFoodItemCategory)
	{
		inventoryServiceImplLogger.info("get iem by given category from database -- service");
		InventoryItem inventoryItem = inventoryItemRepository.findByInventoryFoodItemCategory(inventoryFoodItemCategory);
		if(inventoryItem == null)
		{
			throw new InventoryItemNotFoundException("Item for given category not found");
		}
		InventoryItemResponse fetchedInventoryItemResponse = InventoryFootprintUomMapper.mapInventoryItemToInventoryItemResponse(inventoryItem);
		return fetchedInventoryItemResponse;
	}
	
	@Override
	public InventoryItemResponse findByInventoryFoodItemLpnNumber(String inventoryFoodItemLpnNumber)
	{
		inventoryServiceImplLogger.info("get iem by given lpn number from database -- service");
		InventoryItem inventoryItem = inventoryItemRepository.findByInventoryFoodItemLpnNumber(inventoryFoodItemLpnNumber);
		if(inventoryItem == null)
		{
			throw new InventoryItemNotFoundException("Item for given lpn number not found");
		}
		InventoryItemResponse fetchedInventoryItemResponse = InventoryFootprintUomMapper.mapInventoryItemToInventoryItemResponse(inventoryItem);
		return fetchedInventoryItemResponse;
	}
}
