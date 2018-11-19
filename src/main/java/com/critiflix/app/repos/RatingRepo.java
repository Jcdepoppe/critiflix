package com.critiflix.app.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.critiflix.app.models.Rating;

public interface RatingRepo extends CrudRepository<Rating, Long>{
	List<Rating> findAll(); 
}
