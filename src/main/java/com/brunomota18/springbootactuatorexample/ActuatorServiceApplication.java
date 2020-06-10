package com.brunomota18.springbootactuatorexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ActuatorServiceApplication {

	@Bean
	@Scope("singleton")
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}


	public static void main(String[] args) {
		SpringApplication.run(ActuatorServiceApplication.class, args);
	}

}
