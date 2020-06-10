package com.cognizant.handsOn2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.cognizant.handsOn2"})
public class HandsOn2Application {

	public static void main(String[] args) {
		SpringApplication.run(HandsOn2Application.class, args);
	}

}
