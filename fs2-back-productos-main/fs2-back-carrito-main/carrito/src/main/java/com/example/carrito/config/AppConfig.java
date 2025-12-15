package com.example.carrito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer{

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        final String S3_FRONTEND_URL = "http://bucket-app-stroms-solutions-s3.s3-website-us-east-1.amazonaws.com";

        registry.addMapping("/**") // aplica a todos los endpoints
            .allowedOrigins(S3_FRONTEND_URL, "http://localhost:3000") // permite S3 y localhost
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
            .allowedHeaders("*")
            .allowCredentials(true);
    }

}
