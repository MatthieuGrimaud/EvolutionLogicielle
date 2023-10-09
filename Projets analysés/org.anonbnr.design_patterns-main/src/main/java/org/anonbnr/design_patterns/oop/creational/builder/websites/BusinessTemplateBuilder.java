package org.anonbnr.design_patterns.oop.creational.builder.websites;

// Concrete Builder
public class BusinessTemplateBuilder implements WebsiteBuilder {
	private Website website;
	
	public BusinessTemplateBuilder() {
		website = new Website();
	}

	@Override
	public WebsiteBuilder buildTemplate() {
		website.setTemplate("Business Template");
		return this;
	}

	@Override
	public WebsiteBuilder buildStyle() {
		website.setStyle("Professional and user-friendly");
		return this;
	}

	@Override
	public WebsiteBuilder buildContent() {
		website.setContent("This is an e-commerce website");
		return this;
	}

	@Override
	public Website build() {
		return website;
	}
}
