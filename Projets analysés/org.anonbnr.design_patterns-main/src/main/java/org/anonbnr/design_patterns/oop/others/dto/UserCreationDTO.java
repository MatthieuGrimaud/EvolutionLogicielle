package org.anonbnr.design_patterns.oop.others.dto;

public class UserCreationDTO {
	/* ATTRIBUTES */
	private String username;
	private String name;
	private String password;
	private String email;
	private double latitude;
	private double longitude;
	private String locationName;
	private String locationDescription;
	
	/* METHODS */
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getLocationName() {
		return locationName;
	}
	
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String getLocationDescription() {
		return locationDescription;
	}
	
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
}
