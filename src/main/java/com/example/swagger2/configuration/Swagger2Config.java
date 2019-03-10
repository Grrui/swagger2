package com.example.swagger2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("文档说明--API接口文档")
                        .description("包括保存、查询等")
                        .contact(new Contact("王二牛同学", "https://github.com/Grrui", "grrui218@gmail.com"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger2.controller"))
                .paths(PathSelectors.ant("/api/**")) // 如果适配所有api，可以改为PathSelectors.any()
                .build();
    }
}