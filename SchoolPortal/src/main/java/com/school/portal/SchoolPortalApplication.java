package com.school.portal;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SchoolPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolPortalApplication.class, args);
	}

	/**
	 * * This method is use for get api Docket. * @param Nothing. * @return Docket.
	 */
	/**
	 * @author ankurbansal
	 * @return ApiInfo
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build()
				.pathMapping("/").apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.newArrayList(apiKey()));
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().displayRequestDuration(true).filter(true).build();

	}

	/** * This method is use for get apiInfo * @param Nothing. * @return ApiInfo. */
	/**
	 * @author ankurbansal
	 * @return ApiInfo
	 */
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("Lost Phones  service API").version("1.0").license("(C) Copyright LostPhones")
				.description("The API provides a platform to query build LostPhones exchange api")
				.contact(new Contact("LostPhones", "http://lostphone.org", "lostphone@gmail.com"));
		return builder.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("Authorization", authorizationScopes));
	}
}
