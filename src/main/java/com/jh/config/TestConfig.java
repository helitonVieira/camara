package com.jh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//import com.jh.services.DBService;
import com.jh.services.EmailService;
import com.jh.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	/*@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}*/
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
