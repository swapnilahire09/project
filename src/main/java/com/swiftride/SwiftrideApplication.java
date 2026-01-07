package com.swiftride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.swiftride")
public class SwiftrideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftrideApplication.class, args);
	}

}
