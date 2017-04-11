package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroservicesSimpleServiceApplication {

	@RequestMapping("/service")
	public List<String> execute() {
		return Arrays.asList("Value1", "Value2");
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesSimpleServiceApplication.class, args);
	}
}
