package com.boot.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;

public class MyConfiguration {

	@Bean
	public List<String> cats() {
		return Arrays.asList("tom", "billy", "catty");
	}
}
