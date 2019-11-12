package com.chris.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(HelloworldApplication.class, args);
		 
		System.out.println("k");
	}

}
