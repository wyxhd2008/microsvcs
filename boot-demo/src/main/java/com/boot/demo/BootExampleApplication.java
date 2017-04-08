package com.boot.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Import(MyConfiguration.class)
@ImportResource("/simple-context.xml")
public class BootExampleApplication {

	@Autowired
	@Resource(name="cats")
	public List<String> myCatsList;
	
	@Autowired
	@Resource(name="dogs")
	public List<String> myDogsList;

	@Autowired
	@Resource(name="cows")
	public List<String> myCowsList;

	@RequestMapping("/")
	public String hello() {
		return "Hello from Spring Boot! cats are " + 
				String.join(": ", myCatsList)+" and dogs are " + 
				String.join(": ", myDogsList) + " and cows are " +
				String.join(": ", myCowsList);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootExampleApplication.class, args);
	}
}
