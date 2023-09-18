package com.microservices.food.ordering.order.service.projects.service;

import com.microservices.food.ordering.order.service.projects.dto.OrderRequest;
import com.microservices.food.ordering.order.service.projects.dto.OrderResponse;
import com.microservices.food.ordering.order.service.projects.dto.UserInformationResponse;
import com.microservices.food.ordering.order.service.projects.entity.Orders;

public interface OrderOrderLinesUserAndAddressInformationService {

	UserInformationResponse findUserDeatilsByEmailAddress(String emailAddress);

	UserInformationResponse findUserDeatilsByUserInformationId(Long userInformationId);

	OrderResponse findOrderByOrderId(Long orderId);

	Orders placeNewFoodOrder(OrderRequest orderRequest);

	UserInformationResponse findUserDeatilsByUserCorrespondenceAddressZipCode(String zipCode);

}
