package com.cg.fms;

import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("customer-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/customers/.*"), regex("/orders/.*"), regex("/scheduler/.*"),regex("/contracts/.*"), regex("/cart/.*"), regex("/products/.*"), regex("/Admin/.*"), regex("/Land/.*")
				,regex("/register-adminScheduler/.*"), regex("/register-admin/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Orders API").description("Praveen API reference for developers")
				.termsOfServiceUrl("http://praveen.com").license("praveen License").licenseUrl("r21praveen@cgs.com")
				.version("1.0").build();
	}

}
