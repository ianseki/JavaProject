package com.ian.eventsBeltReview.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ian.eventsBeltReview.models.User;
import com.ian.eventsBeltReview.services.UserService;
import com.ian.eventsBeltReview.validators.UserValidator;

@Controller
public class UserController 
{
	private UserService uService;
	private UserValidator uValidator;
	
	public UserController(UserService uService, UserValidator uValidator)
	{
		this.uService = uService;
		this.uValidator = uValidator; 
	}
	
	@GetMapping("/")
	public String dashboard(
			@ModelAttribute("newUser") User newUser,
			Model model)
	{
		return "dashboard.jsp";
	}
	
	@PostMapping("/")
	public String register(
			@ModelAttribute("newUser") User newUser,
			BindingResult errorMessage,
			HttpSession session)
	{
		uValidator.validate(newUser, errorMessage);
		
		return "";
	}
}
