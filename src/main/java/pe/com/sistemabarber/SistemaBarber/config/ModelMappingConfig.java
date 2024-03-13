package pe.com.sistemabarber.SistemaBarber.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author ACER
 */

import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

