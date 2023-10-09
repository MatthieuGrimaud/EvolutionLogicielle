package org.anonbnr.design_patterns.oop.creational.builder.websites;

public class Main {

	public static void main(String[] args) {
		WebsiteBuilder builder = new BlogTemplateBuilder();
		WebsiteDirector director = new WebsiteDirector(builder);
		Website site = director.build();
		System.out.println(site);
		
		builder = new BusinessTemplateBuilder();
		director = new WebsiteDirector(builder);
		site = director.build();
		System.out.println(site);
	}
}
