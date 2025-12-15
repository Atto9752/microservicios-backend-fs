package com.example.stroms.productos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    
        final String S3_FRONTEND_URL = "http://bucket-app-stroms-solutions-s3.s3-website-us-east-1.amazonaws.com";
        
        registry.addMapping("/**") 
            .allowedOrigins(S3_FRONTEND_URL, "http://localhost:3000") 
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
