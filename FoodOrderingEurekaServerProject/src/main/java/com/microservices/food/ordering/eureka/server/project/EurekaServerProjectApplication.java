package com.microservices.food.ordering.eureka.server.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesFoodOrderingEurekaServerProjectApplication.class, args);
	}

}
