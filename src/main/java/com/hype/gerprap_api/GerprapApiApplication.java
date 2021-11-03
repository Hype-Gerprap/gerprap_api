package com.hype.gerprap_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class GerprapApiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GerprapApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GerprapApiApplication.class, args);
	}

// }

// @SpringBootApplication
// public class GerprapApiApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(GerprapApiApplication.class, args);
// 	}
	

	@Bean //adding swagger to api documentation -> usage: .../swagger-ui.html <--> create application.description on application.properties file*
	public OpenAPI customOpenAPI(@Value("${application.description}") String description){
		return new OpenAPI().info(new Info()
			.title(description)
			.version("1.0")
			.termsOfService("http://swagger.io/terms")
			.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
