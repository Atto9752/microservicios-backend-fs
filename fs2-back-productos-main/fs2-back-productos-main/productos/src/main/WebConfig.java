import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurerv{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // para mapear la config de todos los endpoints como /api/v1/
        registry.addMapping("/api/v1/**") 
                .allowedOrigins("http://localhost:3000", "http://bucket-app-stroms-solutions-s3.s3-website-us-east-1.amazonaws.com/") 
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
