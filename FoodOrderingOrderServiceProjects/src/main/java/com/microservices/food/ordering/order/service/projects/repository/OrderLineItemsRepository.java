package com.microservices.food.ordering.order.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.order.service.projects.entity.OrderLineItems;

@Repository
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, Long> {

}
