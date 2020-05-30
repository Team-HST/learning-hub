package com.hst.learninghub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LearningHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningHubApplication.class, args);
	}

}
