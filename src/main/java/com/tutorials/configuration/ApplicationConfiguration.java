package com.tutorials.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tutorials.repositories.AuthRepo;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public AuthRepo getAuthRepo() {
		return new AuthRepo();
	}

}
