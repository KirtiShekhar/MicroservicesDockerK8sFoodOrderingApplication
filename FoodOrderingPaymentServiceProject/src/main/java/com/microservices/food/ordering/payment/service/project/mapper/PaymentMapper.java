package com.microservices.food.ordering.payment.service.project.mapper;

import com.microservices.food.ordering.payment.service.project.dto.CreditCardInfoRequest;
import com.microservices.food.ordering.payment.service.project.dto.CreditCardInfoResponse;
import com.microservices.food.ordering.payment.service.project.dto.PaymentRequest;
import com.microservices.food.ordering.payment.service.project.dto.PaymentResponse;
import com.microservices.food.ordering.payment.service.project.entity.CreditCardInfo;
import com.microservices.food.ordering.payment.service.project.entity.Payment;

public class PaymentMapper 
{
	public static CreditCardInfo mapCreditCardInfoRequestToCreditCardInfo(CreditCardInfoRequest creditCardInfoRequest)
	{
		CreditCardInfo creditCardInfo = new CreditCardInfo();
		creditCardInfo.setCreditCardHolderName(creditCardInfoRequest.getCreditCardHolderName());
		creditCardInfo.setCreditCardNumber(creditCardInfoRequest.getCreditCardNumber());
		creditCardInfo.setCreditCardExpiredMonth(creditCardInfoRequest.getCreditCardExpiredMonth());
		creditCardInfo.setCreditCardExpiredYear(creditCardInfoRequest.getCreditCardExpiredYear());
		creditCardInfo.setCreditCardSecurityCode(creditCardInfoRequest.getCreditCardSecurityCode());
		return creditCardInfo;
	}
	
	public static CreditCardInfoResponse mapCreditCardInfoToCreditCardInfoResponse(CreditCardInfo creditCardInfo)
	{
		CreditCardInfoResponse creditCardInfoResponse = new CreditCardInfoResponse();
		creditCardInfoResponse.setCreditCardInfoId(creditCardInfo.getCreditCardInfoId());
		creditCardInfoResponse.setCreditCardHolderName(creditCardInfo.getCreditCardHolderName());
		creditCardInfoResponse.setCreditCardNumber(creditCardInfo.getCreditCardNumber());
		creditCardInfoResponse.setCreditCardExpiredMonth(creditCardInfo.getCreditCardExpiredMonth());
		creditCardInfoResponse.setCreditCardExpiredYear(creditCardInfo.getCreditCardExpiredYear());
		creditCardInfoResponse.setCreditCardSecurityCode(creditCardInfo.getCreditCardSecurityCode());
		return creditCardInfoResponse;
	}
	
	public static Payment mapPaymentRequestToPayment(PaymentRequest paymentRequest)
	{
		Payment payment = new Payment();
		payment.setTotalAmount(paymentRequest.getTotalAmount());
		payment.setTotalQuantity(paymentRequest.getTotalQuantity());
		payment.setCreditCardInfo(mapCreditCardInfoRequestToCreditCardInfo(paymentRequest.getCreditCardInfoRequest()));
		return payment;
	}
	
	public static PaymentResponse mapPaymentToPaymentResponse(Payment payment)
	{
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setPaymentId(payment.getPaymentId());
		paymentResponse.setTotalAmount(payment.getTotalAmount());
		paymentResponse.setTotalQuantity(payment.getTotalQuantity());
		paymentResponse.setCreatedTimestamp(payment.getCreatedTimestamp());
		paymentResponse.setCreditCardInfoResponse(mapCreditCardInfoToCreditCardInfoResponse(payment.getCreditCardInfo()));
		return paymentResponse;
	}

}
