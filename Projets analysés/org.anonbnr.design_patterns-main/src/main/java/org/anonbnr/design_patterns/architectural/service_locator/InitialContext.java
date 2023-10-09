package org.anonbnr.design_patterns.architectural.service_locator;

import java.util.Optional;

public class InitialContext {
	/* METHODS */
	public Optional<MessagingService> lookup(String serviceName) {
		if (serviceName.equalsIgnoreCase("EmailService"))
			return Optional.of(new EmailService());
		else if (serviceName.equalsIgnoreCase("SMSService"))
			return Optional.of(new SMSService());
		
		return Optional.empty();
	}
}
