package com.lubear.todoapp.context;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
						.apis(RequestHandlerSelectors.basePackage("com.lubear.todoapp.controller"))
						.paths(PathSelectors.any())
						.build()
						.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
						"Todo App API",
						"REST API for Todo App",
						"1.0",
						"Terms of service",
						new Contact(
										"Lucas",
										"who-is-tofubear.web.app",
										"lucasbear.yo@outlook.com"),
						"License of API", "API license URL", Collections.emptyList());
	}
}