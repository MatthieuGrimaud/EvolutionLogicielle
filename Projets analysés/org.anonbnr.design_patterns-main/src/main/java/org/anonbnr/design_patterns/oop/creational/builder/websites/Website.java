package org.anonbnr.design_patterns.oop.creational.builder.websites;

// Website object
public class Website {
	private String template;
	private String style;
	private String content;
	
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Template: " + template
				+ "\nStyle: " + style
				+ "\nContent: " + content;
	}
}
