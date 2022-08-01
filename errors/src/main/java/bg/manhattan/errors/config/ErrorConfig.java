package bg.manhattan.errors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class ErrorConfig {
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties excMapping = new Properties();
        excMapping.put(NullPointerException.class.getSimpleName(), "null_pointer_exception");
        resolver.setExceptionMappings(excMapping);
        return resolver;
    }

}
