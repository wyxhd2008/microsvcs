package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SpringMicroservicesOauthBasicApplication {

	@RequestMapping("/resource/endpoint")
	public String endpoint() {
		return "This message is protected by the Resource Server!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesOauthBasicApplication.class, args);
	}
}
