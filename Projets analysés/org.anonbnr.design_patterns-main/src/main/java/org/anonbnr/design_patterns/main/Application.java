package org.anonbnr.design_patterns.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
		"org.anonbnr.design_patterns.oop.others.dto"
})
@EnableJpaRepositories(basePackages = {
		"org.anonbnr.design_patterns.oop.others.dto"
})
@SpringBootApplication(scanBasePackages = {
		"org.anonbnr.design_patterns.oop.others.dto"
})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
