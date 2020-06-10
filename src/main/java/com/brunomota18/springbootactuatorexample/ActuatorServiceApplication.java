package com.brunomota18.springbootactuatorexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableHystrix
public class ActuatorServiceApplication {

	@LoadBalanced
	@Bean
	@Scope("singleton")
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}


	public static void main(String[] args) {
		SpringApplication.run(ActuatorServiceApplication.class, args);
	}

}
