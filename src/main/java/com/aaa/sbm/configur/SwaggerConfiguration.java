package com.aaa.sbm.configur;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ fileName:SwaggerConfiguration
 * @ description:
 * @ author:zhz
 * @ createTime:2021/12/14 9:29
 * @ version:1.0.0
 */
@Configuration //加了个 swagger-configuration.xml
public class SwaggerConfiguration {
    /**
     * 创建一个docket
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2) //选择版本
                .apiInfo(apiInfo())
                //.enable(false)  //swagger不能访问
                .select()
                //配置要扫描接口的方式
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //.apis(RequestHandlerSelectors.basePackage("com.aaa.sbm.controller"))
                //路径过滤
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * apiInfo
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多请关注https://swagger.io/tools/swagger-ui/")
                .termsOfServiceUrl("http://www.baidu.com")
                .contact(new Contact("林工","http://www.baidu.com","lin@163.com"))  //联系人  作者信息
                .version("1.0.0")
                .build();
    }
}
