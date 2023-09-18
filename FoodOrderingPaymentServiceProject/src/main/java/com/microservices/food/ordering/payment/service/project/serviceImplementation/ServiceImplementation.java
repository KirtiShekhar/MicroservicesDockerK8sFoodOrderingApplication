package com.microservices.food.ordering.payment.service.project.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.food.ordering.payment.service.project.dto.PaymentRequest;
import com.microservices.food.ordering.payment.service.project.dto.PaymentResponse;
import com.microservices.food.ordering.payment.service.project.entity.CreditCardInfo;
import com.microservices.food.ordering.payment.service.project.entity.Payment;
import com.microservices.food.ordering.payment.service.project.exception.PaymentDetailsNotFoundException;
import com.microservices.food.ordering.payment.service.project.mapper.PaymentMapper;
import com.microservices.food.ordering.payment.service.project.repository.CreditCardInfoRepository;
import com.microservices.food.ordering.payment.service.project.repository.PaymentRepository;
import com.microservices.food.ordering.payment.service.project.service.PaymentService;

@Service
public class ServiceImplementation implements PaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CreditCardInfoRepository creditCardInfoRepository;
	
	@Override
	public Payment processPayment(PaymentRequest paymentRequest)
	{
		Payment payment = PaymentMapper.mapPaymentRequestToPayment(paymentRequest);
		Payment savedPaymentWithCreditCard = paymentRepository.save(payment);
		return savedPaymentWithCreditCard;
	}
	
	@Override
	public PaymentResponse getPaymentByPaymentId(Long paymentid)
	{
		Payment payment = paymentRepository.findByPaymentId(paymentid);
		if(payment == null)
		{
			throw new PaymentDetailsNotFoundException("Payment Details for given id not found");
		}
		PaymentResponse paymentResponse = PaymentMapper.mapPaymentToPaymentResponse(payment);
		return paymentResponse;
	}
	
	@Override
	public List<CreditCardInfo> getAllCreditCardDetails()
	{
		return creditCardInfoRepository.findAll();
	}

}
