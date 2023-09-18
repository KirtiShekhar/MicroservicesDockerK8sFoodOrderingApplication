package com.microservices.food.ordering.order.service.projects.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.food.ordering.order.service.projects.dto.OrderRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderResponse;
import com.microservices.food.ordering.order.service.projects.dto.UserInformationResponse;
import com.microservices.food.ordering.order.service.projects.entity.Orders;
import com.microservices.food.ordering.order.service.projects.service.OrderOrderLinesUserAndAddressInformationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/orders")
public class OrderController 
{
	final static Logger orderControllerlLogger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderOrderLinesUserAndAddressInformationService orderLinesUserAndAddressInformationService;
	
	@PostMapping("paceOrder")
	@Operation(summary = "save new placed food order to the database")
	public ResponseEntity<?> placeNewFoodOrder(@RequestBody OrderRequest orderRequest)
	{
		orderControllerlLogger.info("save new placed food order to the database -- controller");
		Orders savedFoodOrder = orderLinesUserAndAddressInformationService.placeNewFoodOrder(orderRequest);
		return new ResponseEntity<Orders>(savedFoodOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("getById")
	@Operation(summary = "get saved order details by given id from the database")
	public ResponseEntity<?> findOrderByOrderId(@RequestParam Long orderId)
	{
		orderControllerlLogger.info("get saved order details by given id from the database -- controller");
		OrderResponse orderResponse = orderLinesUserAndAddressInformationService.findOrderByOrderId(orderId);
		return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.OK);
	}
	
	@GetMapping("users/getById")
	@Operation(summary = "get saved user details by given id from the database")
	public ResponseEntity<?> findUserDeatilsByUserInformationId(@RequestParam Long userInformationId)
	{
		orderControllerlLogger.info("get saved user details by given id from the database -- controller");
		UserInformationResponse userInformationResponse = orderLinesUserAndAddressInformationService.findUserDeatilsByUserInformationId(userInformationId);
		return new ResponseEntity<UserInformationResponse>(userInformationResponse,HttpStatus.OK);
	}
	
	@GetMapping("users/getByEmailAddress")
	@Operation(summary = "get saved user details by given email aadress from the database")
	public ResponseEntity<?> findUserDeatilsByEmailAddress(@RequestParam String emailAddress)
	{
		orderControllerlLogger.info("get saved user details by given email aadress from the database -- controller");
		UserInformationResponse userInformationResponse = orderLinesUserAndAddressInformationService.findUserDeatilsByEmailAddress(emailAddress);
		return new ResponseEntity<UserInformationResponse>(userInformationResponse,HttpStatus.OK);
	}
	
	@GetMapping("users/getByAddressZipCode")
	@Operation(summary = "get saved user details by given address zip code from the database")
	public ResponseEntity<?> findUserDeatilsByUserCorrespondenceAddressZipCode(@RequestParam String zipCode)
	{
		orderControllerlLogger.info("get saved user details by given address zip code from the database -- controller");
		UserInformationResponse userInformationResponse = orderLinesUserAndAddressInformationService.findUserDeatilsByUserCorrespondenceAddressZipCode(zipCode);
		return new ResponseEntity<UserInformationResponse>(userInformationResponse,HttpStatus.OK);	
	}	
}
