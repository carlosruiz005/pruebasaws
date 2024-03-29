package com.getweb.testing.pruebas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Open Api Swagger3.
 *
 * @author Carlos Ruiz at getweb.mx
 */
@Configuration
public class Swagger3Config {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${application-description}") String appDesciption,
            @Value("${application-version}") String appVersion,
            @Value("${application-title}") String title) {

        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(appVersion)
                        .description(appDesciption)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));

    }

}
