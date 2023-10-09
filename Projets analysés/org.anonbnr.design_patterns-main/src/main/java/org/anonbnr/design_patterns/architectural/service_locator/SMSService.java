package org.anonbnr.design_patterns.architectural.service_locator;

public class SMSService implements MessagingService {
	/* METHODS */
	@Override
	public String getMessageBody() {
		return "sms message";
	}

	@Override
	public String getServiceName() {
		return "SMSService";
	}

}
