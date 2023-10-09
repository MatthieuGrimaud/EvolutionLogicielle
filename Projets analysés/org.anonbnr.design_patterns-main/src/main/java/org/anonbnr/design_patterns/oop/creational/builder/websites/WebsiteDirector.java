package org.anonbnr.design_patterns.oop.creational.builder.websites;

// Director
public class WebsiteDirector {
	private WebsiteBuilder builder;
	
	public WebsiteDirector(WebsiteBuilder builder) {
		this.builder = builder;
	}
	
	public Website build() {
		return builder.buildTemplate()
			.buildStyle()
			.buildContent()
			.build();
	}
}