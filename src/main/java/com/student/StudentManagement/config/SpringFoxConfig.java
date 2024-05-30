package com.student.StudentManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Configuration

public class SpringFoxConfig {

    private static final String AUTHORIZATION_HEADER ="Authorization";



    public List<SecurityScheme> apiKeys(){
        return Arrays.asList(new ApiKey("JWT",AUTHORIZATION_HEADER,"header"));
    }
@Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(apiKeys())
                .securityContexts(Arrays.asList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfo("Student Management application using springboot","Student Management application using spring boot","Version 0.0",
                "https://www.google.com",new Contact("sai srinivas","Developers url","srinivasmysari@gmail.com"),
                "licenses of api ","Api licenses url", Collections.emptyList());


    }


    public SecurityContext securityContext(){
      return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    public List<SecurityReference> defaultAuth(){
        AuthorizationScope auth = new AuthorizationScope("global","access everything");
        AuthorizationScope[] authArr = new AuthorizationScope[1];
        authArr[0]=auth;
      return Arrays.asList(new SecurityReference("JWT",authArr));
    }
}
