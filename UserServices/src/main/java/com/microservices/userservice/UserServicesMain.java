package com.microservices.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServicesMain {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserServicesMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
    	return restTemplateBuilder.build();
    	
    }
}