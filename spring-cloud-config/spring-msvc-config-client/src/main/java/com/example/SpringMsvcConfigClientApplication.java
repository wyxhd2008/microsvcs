package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope(proxyMode=ScopedProxyMode.NO)
@RestController
public class SpringMsvcConfigClientApplication {

	@Value("${hello}")
	private String message;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMsvcConfigClientApplication.class, args);
	}
	
	@RequestMapping("/message")
	private String message() {
		return this.message;
	}
}
