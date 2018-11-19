package com.critiflix.app.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
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
	
	//retrieves a user 
	public User findUser(Long id) { 
	   Optional<User> optionalUser = userRepo.findById(id); 
	   if(optionalUser.isPresent()) { 
	       return optionalUser.get(); 
	   } else { 
	       return null; 
	   } 
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
