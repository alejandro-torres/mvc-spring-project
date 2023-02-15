package alejandro.torres.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import alejandro.torres.controller.dto.UserRegistrationDto;
import alejandro.torres.entity.User;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);
}
