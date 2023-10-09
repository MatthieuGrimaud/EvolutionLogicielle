package org.anonbnr.design_patterns.architectural.service_locator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cache {
	/* ATTRIBUTES */
	private List<MessagingService> services = new ArrayList<>();
	
	/* METHODS */
	public Optional<MessagingService> getService(String serviceName) {
		return services
				.stream()
				.filter(service -> service.getServiceName().equalsIgnoreCase(serviceName))
				.findFirst();
	}
	
	public boolean addService(MessagingService service) {
		if (!services.contains(service))
			return services.add(service);
		return false;
	}
}
