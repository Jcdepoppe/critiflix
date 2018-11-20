package com.critiflix.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.critiflix.app.services.TheaterService;
import com.critiflix.app.services.UserService;

@Controller
@RequestMapping("/theaters")
public class TheaterController {
	private final TheaterService theaterService;
	private final UserService userService;

	public TheaterController(TheaterService theaterService, UserService userService) {
		this.theaterService = theaterService;
		this.userService = userService;
	}
	
	//Display the Entire Zip Code
	@RequestMapping("")
	public String enterzip() {
		return "zip.jsp";
	}

	@RequestMapping(value="/process", method=RequestMethod.POST) 
	public String create(@RequestParam("zipcode") Long zipcode, HttpSession session) { 
		session.setAttribute("zipcode", zipcode);
		return "redirect:/dashboard";
	} 
	
	//Display the dashboard/homepage
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
}









