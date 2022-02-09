package com.train2middle.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.train2middle.rest.*", "com.train2middle.impl"})
@EntityScan(basePackages = {"com.train2middle.dto"})
@EnableJpaRepositories(basePackages = {"com.train2middle.dto.repository"})
public class RestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
}
