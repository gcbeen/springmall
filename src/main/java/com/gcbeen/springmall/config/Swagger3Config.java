package com.gcbeen.springmall.config;

import java.util.ArrayList;
import java.util.List;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

// 文档地址： http://localhost:8080/swagger-ui/index.html#/
@Configuration
// @EnableOpenApi
@EnableKnife4j  // 访问路径ip:port/doc.html
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.gcbeen.springmall.controller"))
                // 为 有 @Api 注解的 Controller 生成 API 文档
                // .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 为 有 @ApiOperation 注解的方法生成 API 文档
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                // 添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring mall")
                .description("super mall")
                .version("openapi: 3.0.0")
                // .version("0.1.0")
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath());

        return result;
    }

    private SecurityContext getContextByPath() {
        return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .operationSelector(oper -> selector(oper))
        // .forPaths(PathSelectors.regex(pathRegex))
        .build();
    }

    boolean selector(OperationContext operationContext) {
        String url = operationContext.requestMappingPattern();
        //这里可以写URL过滤规则
        boolean match = url.matches("/product/.*");
        match = url.matches("/esProduct/.*") || match;
        match = url.matches("/member/readHistory/.*") || match;
        match = url.matches("/order/generateOrder") || match;
        return match;
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }

}
