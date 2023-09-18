package com.microservices.food.ordering.payment.service.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.food.ordering.payment.service.project.dto.PaymentRequest;
import com.microservices.food.ordering.payment.service.project.dto.PaymentResponse;
import com.microservices.food.ordering.payment.service.project.entity.CreditCardInfo;
import com.microservices.food.ordering.payment.service.project.entity.Payment;
import com.microservices.food.ordering.payment.service.project.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/payment")
public class PaymentController 
{
	Logger paymentControllerLogger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("save/Payment")
	@Operation(summary = "Save new Payment to the database")
	public ResponseEntity<?> processPayment(@RequestBody PaymentRequest paymentRequest)
	{
		paymentControllerLogger.info("Save new Payment to the database");
		Payment payment = paymentService.processPayment(paymentRequest);
		return new ResponseEntity<Payment>(payment,HttpStatus.CREATED);
	}
	
	@GetMapping("getById")
	@Operation(summary = "Get Payment By Given Id from database")
	public ResponseEntity<?> getPaymentByPaymentId(@RequestParam Long paymentid)
	{
		paymentControllerLogger.info("Get Payment By GIven Id from database");
		PaymentResponse paymentResponse = paymentService.getPaymentByPaymentId(paymentid);
		return new ResponseEntity<PaymentResponse>(paymentResponse,HttpStatus.OK);
	}
	
	@GetMapping("getAllCreditCardDetails")
	@Operation(summary = "Get All Credit Card Details from database")
	public ResponseEntity<?> getAllCreditCardDetails()
	{
		paymentControllerLogger.info("Get All Credit Card Details from database");
		List<CreditCardInfo> credCardList = paymentService.getAllCreditCardDetails();
		return new ResponseEntity<List<CreditCardInfo>>(credCardList,HttpStatus.OK);
	}

}
