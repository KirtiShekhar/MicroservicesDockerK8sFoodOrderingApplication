package com.microservices.food.ordering.cloud.gateway.api.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-banking-cloud-gateway-api-project", version = "2.0", description = "Spring Boot Application Microservices cloud gateway api project for food ordering application"))
public class CloudGatewayApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesFoodOrderingCloudGatewayApiProjectApplication.class, args);
	}

}