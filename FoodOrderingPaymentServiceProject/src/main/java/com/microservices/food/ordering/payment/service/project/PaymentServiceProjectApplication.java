package com.microservices.food.ordering.payment.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-food-ordering-payment-service-project", version = "2.0", description = "Spring Boot Application Microservices payment services project for food ordering application"))
public class PaymentServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesFoodOrderingPaymentServiceProjectApplication.class, args);
		System.out.println("Starting Application microservices-food-ordering-payment-service-project");
	}

}
