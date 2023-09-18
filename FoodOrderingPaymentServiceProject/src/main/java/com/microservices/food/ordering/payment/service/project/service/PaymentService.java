package com.microservices.food.ordering.payment.service.project.service;

import java.util.List;

import com.microservices.food.ordering.payment.service.project.dto.PaymentRequest;
import com.microservices.food.ordering.payment.service.project.dto.PaymentResponse;
import com.microservices.food.ordering.payment.service.project.entity.CreditCardInfo;
import com.microservices.food.ordering.payment.service.project.entity.Payment;

public interface PaymentService {

	List<CreditCardInfo> getAllCreditCardDetails();

	PaymentResponse getPaymentByPaymentId(Long paymentid);

	Payment processPayment(PaymentRequest paymentRequest);

}
