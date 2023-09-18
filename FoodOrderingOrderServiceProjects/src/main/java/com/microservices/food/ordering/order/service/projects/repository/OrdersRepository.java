package com.microservices.food.ordering.order.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.order.service.projects.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> 
{
	Orders findByOrderId(Long orderId);
}
