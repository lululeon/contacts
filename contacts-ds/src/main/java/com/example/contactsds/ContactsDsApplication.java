package com.example.contactsds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ContactsDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsDsApplication.class, args);
	}

}
