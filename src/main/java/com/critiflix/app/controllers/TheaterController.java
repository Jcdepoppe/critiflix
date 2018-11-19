package com.critiflix.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.critiflix.app.models.Theater;
import com.critiflix.app.services.TheaterService;

@Controller
@RequestMapping("/theaters")
public class TheaterController {
	private final TheaterService theaterService;

	public TheaterController(TheaterService theaterService) {
		this.theaterService = theaterService;
	}
	
	//Display the dashboard/homepage
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("theater") Theater theater) {
		return "home.jsp";
	}
}
