package com.critiflix.app.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UserRepo extends CrudRepository<User, Long>{ 
	List<User> findAll(); 

}
