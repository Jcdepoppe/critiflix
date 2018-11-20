package com.critiflix.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.critiflix.app.models.Rating;
import com.critiflix.app.repos.RatingRepo;

@Service 
public class RatingService {
	private final RatingRepo ratingRepo;
	
	public RatingService(RatingRepo ratingRepo) {
		this.ratingRepo = ratingRepo;
	}



	public Rating create(Rating rating) {
		return ratingRepo.save(rating);
		
	}



	public Rating getRatingById(Long id) {
		Optional<Rating> rating = ratingRepo.findById(id);
		
		if(rating.isPresent()) {
			return rating.get();
		}
		else {
			return null;			
		}
	}



	public Rating updateRating(Rating rating) {
		return ratingRepo.save(rating);
	}



	public void deleteRating(Long id) {
		ratingRepo.deleteById(id);
	}

}
