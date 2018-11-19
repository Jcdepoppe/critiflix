package com.critiflix.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.critiflix.app.models.User;
import com.critiflix.app.services.UserService;
import com.critiflix.app.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}


	//Display registration page
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("user") User user) {
		return "logReg.jsp";
	}


	//Handle registering
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		userValidator.validate(user,  result);
		if(result.hasErrors()) {
			return "logReg.jsp";
		}
		user = userService.registerUser(user);
		session.setAttribute("user", user);
		return "redirect:/theaters";
	}

	//Handle Logging in
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
		if(userService.authenticateUser(email, password)) {
			user = userService.findByEmail(email);
			session.setAttribute("user", user);
			return "redirect:/theaters";
		}
		else {
			model.addAttribute("error", "Username and password do not match");
			return "logReg.jsp";
		}
	}
}
