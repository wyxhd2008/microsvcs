package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class SpringMicroservicesHystrixApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/startClient")
	@HystrixCommand(fallbackMethod="failover", commandProperties={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")
	})
	public List<String> startClient(@RequestParam long time) throws InterruptedException {
		Thread.sleep(time);
		return this.restTemplate.getForObject("http://localhost:8888/service", List.class);
	}
	
	public List<String> failover(long time) {
		return Arrays.asList("valueFromFailover1", "valueFromFailover2");
	} 
		
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesHystrixApplication.class, args);
	}
}
