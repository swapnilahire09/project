package com.swiftride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.swiftride")
@EnableScheduling
public class SwiftrideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftrideApplication.class, args);
	}

}
