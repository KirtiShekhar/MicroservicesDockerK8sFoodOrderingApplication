package com.microservices.food.ordering.configuration.server.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesFoodOrderingConfigurationServerProjectApplication.class, args);
	}

}
