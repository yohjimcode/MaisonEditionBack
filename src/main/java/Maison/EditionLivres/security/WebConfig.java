package Maison.EditionLivres.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permet à l'application Angular de se connecter au backend Spring Boot
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // URL de ton frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes HTTP autorisées
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
