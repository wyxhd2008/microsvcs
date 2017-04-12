package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringMicroservicesZuulApplication {

	@Bean
	public MyZuulPreFilter prefilter() {
		return new MyZuulPreFilter();
	} 

	@Bean
	public MyZuulRoutingFilter routingFilter() {
		return new MyZuulRoutingFilter();
	} 
	
	@Bean
	public MyZuulPostFilter postFilter() {
		return new MyZuulPostFilter();
	} 	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesZuulApplication.class, args);
	}
}
