package com.tavio.bookmarkapi.web.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(
                new Info()
                        .title("Bookmark API")
                        .description("Servicio REST para gestionar libros, posts y usuarios")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Marcos Tavio")
                                .email("marcos@example.com"))
        );
    }

    // Si quieres exponer sólo tu paquete “web.controller”
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.tavio.bookmarkapi.web.controller")
                .build();
    }
}