package com;

import org.springframework.context.annotation.Bean;

public class AppConfig {
	
	@Bean
	public IBean getBean() {
		return new MyBean();
	}

}
