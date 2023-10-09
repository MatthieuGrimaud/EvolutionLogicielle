package org.anonbnr.design_patterns.architectural.service_locator;

public class EmailService implements MessagingService {
	/* METHODS */
	@Override
	public String getMessageBody() {
		return "email message";
	}

	@Override
	public String getServiceName() {
		return "EmailService";
	}

}
