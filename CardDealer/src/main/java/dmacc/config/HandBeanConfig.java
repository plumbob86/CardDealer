package dmacc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.model.Hand;

@Configuration
public class HandBeanConfig {
	
	@Bean
	public Hand hand() {
		Hand hand = new Hand();
		return hand;
	}

}
