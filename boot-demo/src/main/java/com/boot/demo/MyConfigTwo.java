package com.boot.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigTwo {
	@Bean
	public List<String> dogs() {
		return Arrays.asList("dog1", "dog2", "dog3");
	}
}
