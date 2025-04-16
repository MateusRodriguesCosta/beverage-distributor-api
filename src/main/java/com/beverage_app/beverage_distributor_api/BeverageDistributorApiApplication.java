package com.beverage_app.beverage_distributor_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class BeverageDistributorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeverageDistributorApiApplication.class, args);
	}

}
