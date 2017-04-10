package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringEurekaClientTwoApplication {
	
	@Autowired
	private EurekaClient client;

	@RequestMapping("/serviceinfo")
	private String serviceInfo() {
		InstanceInfo instance = client.getNextServerFromEureka("MyClientOne", false);
		StringBuffer sBuffer = new StringBuffer("");
		sBuffer.append("Home Page Url: " + instance.getHomePageUrl() +
						"<BR/>App Name " + instance.getAppName() +
						"<BR/>IP Address " + instance.getIPAddr() +
						"<BR/>Port " + instance.getPort() 
						);
		return sBuffer.toString();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientTwoApplication.class, args);
	}
}
