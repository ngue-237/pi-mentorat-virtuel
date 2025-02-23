package com.logonedigital.pi_mentorat_virtuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class 	PiMentoratVirtuelApplication {


	public static void main(String[] args) {
		SpringApplication.run(PiMentoratVirtuelApplication.class, args);
	}

}
