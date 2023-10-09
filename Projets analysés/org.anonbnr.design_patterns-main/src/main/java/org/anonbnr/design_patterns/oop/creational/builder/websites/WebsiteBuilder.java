package org.anonbnr.design_patterns.oop.creational.builder.websites;

// Builder interface
public interface WebsiteBuilder {
	WebsiteBuilder buildTemplate();
	WebsiteBuilder buildStyle();
	WebsiteBuilder buildContent();
	Website build();
}
