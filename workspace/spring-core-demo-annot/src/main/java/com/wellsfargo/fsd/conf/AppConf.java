package com.wellsfargo.fsd.conf;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.wellsfargo.fsd.service")
@PropertySource("data.properties")
public class AppConf {

	@Bean
	@Scope("prototype")
	public LocalDateTime today() {
		return LocalDateTime.now();
	}
	
}
