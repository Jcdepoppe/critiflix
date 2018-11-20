package com.critiflix.app.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.critiflix.app.models.MovieTime;

@Repository 
public interface MovieTimeRepo extends CrudRepository<MovieTime, Long>{ 
	List<MovieTime> findAll(); 

}