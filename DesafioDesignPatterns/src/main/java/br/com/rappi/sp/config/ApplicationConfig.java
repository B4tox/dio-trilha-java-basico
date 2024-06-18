package br.com.rappi.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rappi.sp.exception.CustomErrorDecoder;

@Configuration
public class ApplicationConfig {

	@Bean
	public CustomErrorDecoder myErrorDecoder() {
		return new CustomErrorDecoder();
	}
}