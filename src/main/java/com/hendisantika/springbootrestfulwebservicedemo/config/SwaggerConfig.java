package com.hendisantika.springbootrestfulwebservicedemo.config;

import com.google.common.base.Predicate;
import com.hendisantika.springbootrestfulwebservicedemo.model.reference.ApiInfoReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:49
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private ApiInfoReference apiInfoReference;

    /*
     * Docket bean in a Spring Boot configuration to configure Swagger 2 for the
     * application. A Springfox Docket instance provides the primary API
     * configuration with sensible defaults and convenience methods for
     * configuration
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(" com.hendisantika.springbootrestfulwebservicedemo.controller"))
                .paths(PathSelectors.ant("/**")).build();

        /* paths(PathSelectors.any()) */

    }

    // Swagger configuration is applied only following regex
    private Predicate<String> postPaths() {
        return or(regex("/api/*"), regex("/api/secure*"));
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Hendi Santika", "http://hendisantika.wordpress.com", "hendisantika@gmail.com");
        return new ApiInfoBuilder()
                .title("Spring Boot Restful Webservice Demo")
                .description("Spring Boot Restful Webservice Demo")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

}