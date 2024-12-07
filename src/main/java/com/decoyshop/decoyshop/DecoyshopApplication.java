package com.decoyshop.decoyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"entities"})
@SpringBootApplication
public class DecoyshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecoyshopApplication.class, args);
	}

}
