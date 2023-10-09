package org.anonbnr.design_patterns.architectural.service_locator;

import java.util.Optional;

public class ServiceLocator {
	/* ATTRIBUTES */
	private static Cache cache = new Cache();
	
	/* METHODS */
	public static MessagingService getService(String serviceName) {
		Optional<MessagingService> serviceWrapper = cache.getService(serviceName);
		if (serviceWrapper.isPresent())
			return serviceWrapper.get();
		
		InitialContext context = new InitialContext();
		serviceWrapper = context.lookup(serviceName);
		MessagingService service = serviceWrapper.get();
		cache.addService(service);
		return service;
	}
}
