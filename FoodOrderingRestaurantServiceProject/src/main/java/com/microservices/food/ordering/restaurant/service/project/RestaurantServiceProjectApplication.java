package com.microservices.food.ordering.restaurant.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-food-ordering-restaurant-service-project", version = "2.0", description = "Spring Boot Application Microservices restaurant services project for food ordering application"))
public class RestaurantServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesFoodOrderingRestaurantServiceProjectApplication.class, args);
		System.out.println("Starting Application microservices-food-ordering-restaurant-service-project");
	}

}
