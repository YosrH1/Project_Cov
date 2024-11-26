package BackendCovoiturage.BackendCovoiturage.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints starting with /api/
        registry.addMapping("/api/**") // This is the URL pattern to allow CORS for
                .allowedOrigins("http://localhost:3000") // Allow requests from the React app running on localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                .allowedHeaders("*") // Allow all headers (for requests like JSON)
                .allowCredentials(true); // Allow sending cookies or authentication info (like JWT tokens)
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
