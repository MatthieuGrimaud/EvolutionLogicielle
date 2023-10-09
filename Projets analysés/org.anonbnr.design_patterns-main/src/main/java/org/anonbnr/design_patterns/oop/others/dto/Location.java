package org.anonbnr.design_patterns.oop.others.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
	/* ATTRIBUTES */
	@Id
	@GeneratedValue
	private long id;
	private double latitude;
	private double longitude;
	private String name;
	private String description;
	
	/* CONSTRUCTORS */
	public Location() {
		
	}

	public Location(double latitude, double longitude, String name, 
			String description) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.description = description;
	}

	/* METHODS */
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
