package org.anonbnr.design_patterns.oop.creational.builder.websites;

// Concrete Builder
public class BlogTemplateBuilder implements WebsiteBuilder {
	private Website website;
	
	public BlogTemplateBuilder() {
		website = new Website();
	}

	@Override
	public WebsiteBuilder buildTemplate() {
		website.setTemplate("Blog Template");
		return this;
	}

	@Override
	public WebsiteBuilder buildStyle() {
		website.setStyle("Clean and simple");
		return this;
	}

	@Override
	public WebsiteBuilder buildContent() {
		website.setContent("This is a blog about something");
		return this;
	}

	@Override
	public Website build() {
		return website;
	}
}
