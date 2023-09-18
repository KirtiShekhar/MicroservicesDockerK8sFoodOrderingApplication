package com.microservices.food.ordering.order.service.projects.serviceImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.food.ordering.order.service.projects.dto.AddressInformationRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderLineItemsRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderResponse;
import com.microservices.food.ordering.order.service.projects.dto.UserInformationRequest;
import com.microservices.food.ordering.order.service.projects.dto.UserInformationResponse;
import com.microservices.food.ordering.order.service.projects.entity.AddressInformation;
import com.microservices.food.ordering.order.service.projects.entity.OrderLineItems;
import com.microservices.food.ordering.order.service.projects.entity.Orders;
import com.microservices.food.ordering.order.service.projects.entity.UserInformation;
import com.microservices.food.ordering.order.service.projects.exception.OrderDetailsNotFoundException;
import com.microservices.food.ordering.order.service.projects.exception.UserInfoNotFoundException;
import com.microservices.food.ordering.order.service.projects.mapper.OrderServiceMapper;
import com.microservices.food.ordering.order.service.projects.repository.AddressInformationRepository;
import com.microservices.food.ordering.order.service.projects.repository.OrderLineItemsRepository;
import com.microservices.food.ordering.order.service.projects.repository.OrdersRepository;
import com.microservices.food.ordering.order.service.projects.repository.UserInformationRepository;
import com.microservices.food.ordering.order.service.projects.service.OrderOrderLinesUserAndAddressInformationService;

@Service
public class ServiceImplementation implements OrderOrderLinesUserAndAddressInformationService
{
	final static Logger orderServiceImplLogger = LoggerFactory.getLogger(OrderOrderLinesUserAndAddressInformationServiceImplementation.class);
	
	@Autowired
	private UserInformationRepository userInformationRepository;
	
	@Autowired
	private AddressInformationRepository addressInformationRepository;
	
	@Autowired
	private OrderLineItemsRepository orderLineItemsRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public OrderLineItems createNewOrderLine(OrderLineItemsRequest orderLineItemsRequest)
	{
		orderServiceImplLogger.info("save new orderline to the database -- service");
		OrderLineItems orderLineItems = OrderServiceMapper.mapOrderLineItemsRequestToOrderLineItems(orderLineItemsRequest);
		OrderLineItems savedOrderLineItems = orderLineItemsRepository.save(orderLineItems);
		return savedOrderLineItems;
	}
	
	public AddressInformation createNewAddressInfo(AddressInformationRequest addressInformationRequest)
	{
		orderServiceImplLogger.info("save new address info to the database -- service");
		AddressInformation addressInformation = OrderServiceMapper.mapAddressInformationRequestToAddressInformation(addressInformationRequest);
		AddressInformation savedAddressInformation = addressInformationRepository.save(addressInformation);
		return savedAddressInformation;
	}
	
	public UserInformation createNewUserInfo(UserInformationRequest userInfoRequest)
	{
		orderServiceImplLogger.info("save new user info to the database -- service");
		createNewAddressInfo(userInfoRequest.getUserCorrespondenceAddressRequest());
		createNewAddressInfo(userInfoRequest.getUserPermanentAddressRequest());
		UserInformation userInformation = OrderServiceMapper.mapUserInformationRequestToUserInformation(userInfoRequest);
		UserInformation savedUserInformation = userInformationRepository.save(userInformation);
		return savedUserInformation;
	}
	
	@Override
	public Orders placeNewFoodOrder(OrderRequest orderRequest)
	{
		orderServiceImplLogger.info("save new placed food order to the database -- service");
		createNewUserInfo(orderRequest.getUserInfoRequest());
		createNewOrderLine(orderRequest.getOrderLineItemsRequest());
		Orders orders = OrderServiceMapper.mapOrderRequestToOrders(orderRequest);
		Orders savedFoodOrder = ordersRepository.save(orders);
		return savedFoodOrder;
	}
	
	@Override
	public OrderResponse findOrderByOrderId(Long orderId)
	{
		orderServiceImplLogger.info("get saved order details from the database -- service");
		Orders fetchedOrders = ordersRepository.findByOrderId(orderId);
		if(fetchedOrders == null)
		{
			throw new OrderDetailsNotFoundException("Order details not found for given id");
		}
		OrderResponse orderResponse = OrderServiceMapper.mapOrdersToOrderResponse(fetchedOrders);
		return orderResponse;
	}
	
	@Override
	public UserInformationResponse findUserDeatilsByUserInformationId(Long userInformationId)
	{
		orderServiceImplLogger.info("get saved user details by given id from the database -- service");
		UserInformation fetchedUserInformation = userInformationRepository.findByUserInformationId(userInformationId);
		if(fetchedUserInformation == null)
		{
			throw new UserInfoNotFoundException("User details not found for given id");
		}
		UserInformationResponse userInformationResponse = OrderServiceMapper.mapUserInformationToUserInformationResponse(fetchedUserInformation);
		return userInformationResponse;
	}
	
	@Override
	public UserInformationResponse findUserDeatilsByEmailAddress(String emailAddress)
	{
		orderServiceImplLogger.info("get saved user details by given email aadress from the database -- service");
		UserInformation fetchedUserInformation = userInformationRepository.findByEmailAddress(emailAddress);
		if(fetchedUserInformation == null)
		{
			throw new UserInfoNotFoundException("User details not found for given email address");
		}
		UserInformationResponse userInformationResponse = OrderServiceMapper.mapUserInformationToUserInformationResponse(fetchedUserInformation);
		return userInformationResponse;
	}
	
	@Override
	public UserInformationResponse findUserDeatilsByUserCorrespondenceAddressZipCode(String zipCode)
	{
		orderServiceImplLogger.info("get saved user details by given address zip code from the database -- service");
		UserInformation fetchedUserInformation = userInformationRepository.findByUserCorrespondenceAddressZipCode(zipCode);
		if(fetchedUserInformation == null)
		{
			throw new UserInfoNotFoundException("User details not found for given address zip code");
		}
		UserInformationResponse userInformationResponse = OrderServiceMapper.mapUserInformationToUserInformationResponse(fetchedUserInformation);
		return userInformationResponse;		
	}	
}
