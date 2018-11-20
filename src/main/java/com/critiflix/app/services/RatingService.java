package com.critiflix.app.services;

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

}
