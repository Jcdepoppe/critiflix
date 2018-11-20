package com.critiflix.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.critiflix.app.models.Rating;
import com.critiflix.app.services.RatingService;

@Controller
@RequestMapping("/ratings")
public class RatingController {
	private final RatingService ratingService;

	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}
	
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("rating") Rating rating) {
		return "newReview.jsp";
	}
	
	@RequestMapping("/create")
	public String create(@ModelAttribute("rating") Rating rating, BindingResult result) {
		double sum = rating.getCleanliness() + rating.getFoodQuality() + rating.getService();
		System.out.println(sum);
		double avg = sum / 3;
		System.out.println(avg);
		rating.setAggregate(avg);
		rating = ratingService.create(rating);
		return "redirect:/theaters";
	}
	
}
