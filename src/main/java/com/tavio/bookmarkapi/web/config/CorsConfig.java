package com.tavio.bookmarkapi.web.config;
import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    private final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(
                List.of(dotenv.get("ALLOWED_ORIGIN", "*")) 
        );
        cors.setAllowedMethods(List.of("POST","PUT","GET","OPTIONS","DELETE"));
        cors.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**", cors);
        return src;
    }
}
