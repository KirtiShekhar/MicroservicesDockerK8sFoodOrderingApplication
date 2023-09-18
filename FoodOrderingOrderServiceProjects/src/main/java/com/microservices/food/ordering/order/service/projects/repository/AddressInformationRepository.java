package com.microservices.food.ordering.order.service.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.order.service.projects.entity.AddressInformation;

@Repository
public interface AddressInformationRepository extends JpaRepository<AddressInformation, Long> {

}
