package com.assignment.callsign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CallsignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallsignApplication.class, args);
	}

}
