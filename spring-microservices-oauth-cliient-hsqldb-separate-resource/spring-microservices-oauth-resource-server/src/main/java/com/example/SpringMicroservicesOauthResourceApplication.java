package com.example;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringMicroservicesOauthResourceApplication {

	@RequestMapping("/resource/endpoint")
	@PreAuthorize("hasRole('ADMIN')")
	public String endpoint(Principal principal) {
		return "Welcome " + principal.getName() + ", this message is protected by the Resource Server!";
	}
	
	@Bean
	public RemoteTokenServices remoteTokenServices() {
      RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
      remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
      remoteTokenServices.setClientId("resource1");			// as in the schema .sql file
      remoteTokenServices.setClientSecret("secret");
      return remoteTokenServices;
   }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesOauthResourceApplication.class, args);
	}
	
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource());
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:hsql://localhost/testdb");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		return dataSource;
	}	
}
