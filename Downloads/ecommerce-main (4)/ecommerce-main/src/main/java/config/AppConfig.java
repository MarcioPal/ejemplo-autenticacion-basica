package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {
    @Configuration
    public class ImagenConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            WebMvcConfigurer.super.addResourceHandlers(registry);
            registry.addResourceHandler("/imagenes/**").addResourceLocations("/home/emma/Facultad/imagenes");
        }

    }
}