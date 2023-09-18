package com.microservices.food.ordering.payment.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.food.ordering.payment.service.project.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> 
{
	Payment findByPaymentId(Long paymentid);
}
