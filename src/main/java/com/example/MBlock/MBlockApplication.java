package com.example.MBlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MBlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MBlockApplication.class, args);
	}

}
