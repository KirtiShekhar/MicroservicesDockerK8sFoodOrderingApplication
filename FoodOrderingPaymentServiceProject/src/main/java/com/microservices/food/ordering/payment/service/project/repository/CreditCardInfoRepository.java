package com.microservices.food.ordering.payment.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.payment.service.project.entity.CreditCardInfo;

@Repository
public interface CreditCardInfoRepository extends JpaRepository<CreditCardInfo, Long> {

}
