package com.critiflix.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.critiflix.app.models.User;
import com.critiflix.app.repos.UserRepo;

@Service 
public class UserService { 
	private final UserRepo userRepo; 

	public UserService(UserRepo userRepo) { 
		this.userRepo = userRepo; 
	} 
	
	//returns all the users 
	public List<User> allUsers() { 
	   return userRepo.findAll(); 
	} 
	
	//creates a user 
	public User createUser(User user) { 
	   return userRepo.save(user); 
	} 
	
	//retrieves a user 
	public User findUser(Long id) { 
	   Optional<User> optionalUser = userRepo.findById(id); 
	   if(optionalUser.isPresent()) { 
	       return optionalUser.get(); 
	   } else { 
	       return null; 
	   } 
	} 
}
