package com.microservices.food.ordering.order.service.projects.mapper;

import com.microservices.food.ordering.order.service.projects.dto.AddressInformationRequest;
import com.microservices.food.ordering.order.service.projects.dto.AddressInformationResponse;
import com.microservices.food.ordering.order.service.projects.dto.OrderLineItemsRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderLineItemsResponse;
import com.microservices.food.ordering.order.service.projects.dto.OrderRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderResponse;
import com.microservices.food.ordering.order.service.projects.dto.UserInformationRequest;
import com.microservices.food.ordering.order.service.projects.dto.UserInformationResponse;
import com.microservices.food.ordering.order.service.projects.entity.AddressInformation;
import com.microservices.food.ordering.order.service.projects.entity.OrderLineItems;
import com.microservices.food.ordering.order.service.projects.entity.Orders;
import com.microservices.food.ordering.order.service.projects.entity.UserInformation;

public class OrderServiceMapper 
{
	public static AddressInformation mapAddressInformationRequestToAddressInformation(AddressInformationRequest addressInformationRequest)
	{
		AddressInformation addressInformation = new AddressInformation();
		addressInformation.setAddressLine1(addressInformationRequest.getAddressLine1());
		addressInformation.setAddressLine2(addressInformationRequest.getAddressLine2());
		addressInformation.setCity(addressInformationRequest.getCity());
		addressInformation.setState(addressInformationRequest.getState());
		addressInformation.setZipCode(addressInformationRequest.getZipCode());
		return addressInformation;
	}
	
	public static AddressInformationResponse mapAddressInformationToAddressInformationResponse(AddressInformation addressInformation)
	{
		AddressInformationResponse addressInformationResponse = new AddressInformationResponse();
		addressInformationResponse.setAddressInformationId(addressInformation.getAddressInformationId());
		addressInformationResponse.setAddressLine1(addressInformation.getAddressLine1());
		addressInformationResponse.setAddressLine2(addressInformation.getAddressLine2());
		addressInformationResponse.setCity(addressInformation.getCity());
		addressInformationResponse.setState(addressInformation.getState());
		addressInformationResponse.setZipCode(addressInformation.getZipCode());
		return addressInformationResponse;
	}
	
	public static OrderLineItems mapOrderLineItemsRequestToOrderLineItems(OrderLineItemsRequest orderLineItemsRequest)
	{
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsRequest.getPrice());
		orderLineItems.setQuantity(orderLineItems.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsRequest.getSkuCode());
		return orderLineItems;
	}
	
	public static OrderLineItemsResponse mapOrderLineItemsToOrderLineItemsResponse(OrderLineItems orderLineItems)
	{
		OrderLineItemsResponse orderLineItemsResponse = new OrderLineItemsResponse();
		orderLineItemsResponse.setOrderLineItemsId(orderLineItems.getOrderLineItemsId());
		orderLineItemsResponse.setPrice(orderLineItems.getPrice());
		orderLineItemsResponse.setQuantity(orderLineItems.getQuantity());
		orderLineItemsResponse.setSkuCode(orderLineItems.getSkuCode());
		return orderLineItemsResponse;
	}
	
	public static UserInformation mapUserInformationRequestToUserInformation(UserInformationRequest userInformationRequest)
	{
		UserInformation userInformation = new UserInformation();
		userInformation.setUserName(userInformationRequest.getUserName());
		userInformation.setUserFullName(userInformationRequest.getUserFullName());
		userInformation.setContactNumber(userInformationRequest.getContactNumber());
		userInformation.setEmailAddress(userInformationRequest.getEmailAddress());
		userInformation.setUserCorrespondenceAddress(mapAddressInformationRequestToAddressInformation(userInformationRequest.getUserCorrespondenceAddressRequest()));
		userInformation.setUserPermanentAddress(mapAddressInformationRequestToAddressInformation(userInformationRequest.getUserPermanentAddressRequest()));
		return userInformation;
	}
	
	public static UserInformationResponse mapUserInformationToUserInformationResponse(UserInformation userInformation)
	{
		UserInformationResponse userInformationResponse = new UserInformationResponse();
		userInformationResponse.setUserInformationId(userInformation.getUserInformationId());
		userInformationResponse.setUserName(userInformation.getUserName());
		userInformationResponse.setUserFullName(userInformation.getUserFullName());
		userInformationResponse.setContactNumber(userInformation.getContactNumber());
		userInformationResponse.setEmailAddress(userInformation.getEmailAddress());
		userInformationResponse.setUserCorrespondenceAddressResponse(mapAddressInformationToAddressInformationResponse(userInformation.getUserCorrespondenceAddress()));
		userInformationResponse.setUserPermanentAddressResponse(mapAddressInformationToAddressInformationResponse(userInformation.getUserPermanentAddress()));
		return userInformationResponse;
	}
	
	public static Orders mapOrderRequestToOrders(OrderRequest orderRequest)
	{
		Orders orders = new Orders();
		orders.setRestaurantId(orderRequest.getRestaurantId());
		orders.setOrderSpecialNote(orderRequest.getOrderSpecialNote());
		orders.setDelivaryNote(orderRequest.getDelivaryNote());
		orders.setTotalAmount(orderRequest.getTotalAmount());
		orders.setOrderCreatedTime(orderRequest.getOrderCreatedTime());
		orders.setDelivaryTime(orderRequest.getDelivaryTime());
		orders.setOrderLineItems(mapOrderLineItemsRequestToOrderLineItems(orderRequest.getOrderLineItemsRequest()));
		orders.setUserInfo(mapUserInformationRequestToUserInformation(orderRequest.getUserInfoRequest()));
		return orders;
	}
	
	public static OrderResponse mapOrdersToOrderResponse(Orders orders)
	{
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(orders.getOrderId());
		orderResponse.setRestaurantId(orders.getRestaurantId());
		orderResponse.setOrderSpecialNote(orders.getOrderSpecialNote());
		orderResponse.setDelivaryNote(orders.getDelivaryNote());
		orderResponse.setTotalAmount(orders.getTotalAmount());
		orderResponse.setOrderCreatedTime(orders.getOrderCreatedTime());
		orderResponse.setDelivaryTime(orders.getDelivaryTime());
		orderResponse.setOrderLineItemsResponse(mapOrderLineItemsToOrderLineItemsResponse(orders.getOrderLineItems()));
		orderResponse.setUserInfoResponse(mapUserInformationToUserInformationResponse(orders.getUserInfo()));
		return orderResponse;
	}

}
