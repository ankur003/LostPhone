package com.school.portal;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.school.portal.domain.Role;
import com.school.portal.domain.User;
import com.school.portal.repo.UserRepo;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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
				.pathMapping("/").apiInfo(apiInfo()).useDefaultResponseMessages(false);
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
}
