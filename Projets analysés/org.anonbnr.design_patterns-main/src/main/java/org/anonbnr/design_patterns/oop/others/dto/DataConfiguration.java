package org.anonbnr.design_patterns.oop.others.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
	/* ATTRIBUTES */
	private Logger logger = LoggerFactory.getLogger(DataConfiguration.class);
	
	/* METHODS */
	@Bean
	public CommandLineRunner initDatabase(IUserRepository userRepo, 
			ILocationRepository locationRepo) {
		return args -> {
			Location location = new Location(30.45, 78.06, "New York", 
					"The Big Apple.");
			
			User john = new User("johndoe", "John Doe", 
					String.valueOf("1234"), 
					"john.doe@example.com");
			john.setLocation(location);
			
			User jane = new User("janedoe", "Jane Doe", 
					String.valueOf("qwerty"), 
					"jane.doe@example.com");
			jane.setLocation(location);
			
			logger.info("Preloading database with " + locationRepo.save(location));
			logger.info("Preloading database with " + userRepo.save(john));
			logger.info("Preloading database with " + userRepo.save(jane));
		};
	}
}
