package com.ensa.absence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = {"com.ensa.absence", "springboot.rest"})
public class AbsenceApplication {
	
  
	public static void main(String[] args) {
		SpringApplication.run(AbsenceApplication.class, args);
	}
	
	@Bean
    CommandLineRunner runner() {
      return args -> {
      };
      
	}
}
