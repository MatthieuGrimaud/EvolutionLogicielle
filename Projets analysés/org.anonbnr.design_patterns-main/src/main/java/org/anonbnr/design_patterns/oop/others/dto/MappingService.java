package org.anonbnr.design_patterns.oop.others.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
	/* ATTRIBUTES */
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private ILocationRepository locationRepo;
	
	/* METHODS */
	public List<UserLocationDTO> getAllUserLocations(){
		return userRepo.findAll()
				.stream()
				.map(this::toUserLocationDTO)
				.collect(Collectors.toList());
	}
	
	public UserLocationDTO createUserAndLocation(UserCreationDTO dto) {
		User user = toUser(dto);
		Location location = user.getLocation();
		
		location = locationRepo.save(location);
		user = userRepo.save(user);
		
		return toUserLocationDTO(user);
	}
	
	/* Maps User -> UserLocationDTO */
	private UserLocationDTO toUserLocationDTO(User user) {
		UserLocationDTO dto = new UserLocationDTO();
		
		dto.setUsername(user.getUsername());
		dto.setLatitude(user.getLocation().getLatitude());
		dto.setLongitude(user.getLocation().getLongitude());
		dto.setLocationName(user.getLocation().getName());
		
		return dto;
	}
	
	/* Maps UserCreationDTO -> User */
	private User toUser(UserCreationDTO dto) {
		User user = new User(
			dto.getUsername(),
			dto.getName(),
			dto.getPassword(),
			dto.getEmail()
		);
		
		user.setLocation(new Location(
				dto.getLatitude(),
				dto.getLongitude(),
				dto.getLocationName(),
				dto.getLocationDescription()
		));
		
		return user;
	}
}
