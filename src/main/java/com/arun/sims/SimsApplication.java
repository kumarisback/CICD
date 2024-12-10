package com.arun.sims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
public class SimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimsApplication.class, args);
	}

}
