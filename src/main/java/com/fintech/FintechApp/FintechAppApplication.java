package com.fintech.FintechApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class FintechAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintechAppApplication.class, args);
	}

}
