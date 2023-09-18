package com.microservices.food.ordering.cloud.gateway.api.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.AuthorizeExchangeSpec;

@Configuration
@EnableWebFluxSecurity
public class Oauth2SecurityConfiguration 
{
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)
	{
		http.authorizeExchange(new Customizer<AuthorizeExchangeSpec>() {
			@Override
			public void customize(AuthorizeExchangeSpec exchanges) {
				exchanges.pathMatchers("api/restaurant/**").authenticated()
						.pathMatchers("api/payment/**").authenticated()
						.pathMatchers("api/orders/**").authenticated()
						.pathMatchers("api/inventory/**").authenticated();
			}
		}).oauth2ResourceServer().jwt();
		http.csrf().disable();
		return http.build();
	}

}
