package org.anonbnr.design_patterns.oop.others.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
	/* ATTRIBUTES */
	@Autowired
	private MappingService service;
	
	/* METHODS */
	@GetMapping("/users")
	@ResponseBody
	public List<UserLocationDTO> getAllUserLocations(){
		return service.getAllUserLocations();
	}
	
	@PostMapping("/users")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public UserLocationDTO createUserAndLocation(@RequestBody UserCreationDTO dto) {
		return service.createUserAndLocation(dto);
	}
}