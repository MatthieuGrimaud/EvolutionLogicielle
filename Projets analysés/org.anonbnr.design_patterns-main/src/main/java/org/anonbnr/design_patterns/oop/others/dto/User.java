package org.anonbnr.design_patterns.oop.others.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
	/* ATTRIBUTES */
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String name;
	private String password;
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "location_id")
	private Location location;
	
	/* CONSTRUCTORS */
	public User() {
		
	}

	public User(String username, String name, 
			String password, String email) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	/* METHODS */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
