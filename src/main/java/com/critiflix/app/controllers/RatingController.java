package com.critiflix.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.critiflix.app.models.Rating;
import com.critiflix.app.models.User;
import com.critiflix.app.services.RatingService;

@Controller
@RequestMapping("/ratings")
public class RatingController {
	private final RatingService ratingService;

	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}
	
	@RequestMapping("")
	public String ratingIndex(Model model, @ModelAttribute("rating") Rating rating) {
		return "newReview.jsp";
	}
	
	@RequestMapping("/create")
	public String createRating(@ModelAttribute("rating") Rating rating, BindingResult result, HttpSession session, Model model) {
		double sum = rating.getCleanliness() + rating.getFoodQuality() + rating.getService();
		double avg = sum / 3;
		rating.setAggregate(avg);
		User user = (User)session.getAttribute("user");
		rating.setUser(user);
		//request.getParameter("stars");
		//Get the theater object and add the rating to its rating list
		rating = ratingService.create(rating);
		model.addAttribute("rating", rating);
		return "test.jsp";
	}
	
	@RequestMapping("/{id}/edit")
	public String editRating(Model model, @PathVariable("id") Long id) {
		Rating rating = ratingService.getRatingById(id);
		model.addAttribute("rating", rating);
		return "editRating.jsp";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.PUT)
	public String updateRating(@ModelAttribute("rating") Rating rating, HttpSession session, Model model) {
		
		double sum = rating.getCleanliness() + rating.getFoodQuality() + rating.getService();
		rating.setAggregate(sum / 3);
		User user = (User)session.getAttribute("user");
		rating.setUser(user);
		ratingService.updateRating(rating);
		model.addAttribute("rating", rating);
		return "test.jsp";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.DELETE)
	public String destroyRating(@PathVariable("id") Long id) {
		ratingService.deleteRating(id);
		return "redirect:/theaters";
	}
}
