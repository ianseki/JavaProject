package com.ian.javaBeltExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ian.javaBeltExam.models.User;
import com.ian.javaBeltExam.services.UserService;
import com.ian.javaBeltExam.validators.UserValidator;

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
	public String regAndLog(@ModelAttribute("newUser") User newUser)
	{
		return "registrationAndLogin.jsp";
	}
	
	@PostMapping("/")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult errorMessage,
			HttpSession session)
	{
		uValidator.validate(newUser, errorMessage);
		if (errorMessage.hasErrors())
		{
			return "registrationAndLogin.jsp";
		}
		
		User user = this.uService.registerUser(newUser);
		session.setAttribute("userId", user.getId());
		return "redirect:/ideas";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			RedirectAttributes redirs)
	{
		if (this.uService.authenticateUser(email, password))
		{
			User user = this.uService.getUserByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/ideas";
		}
		
		redirs.addFlashAttribute("error", "Invalid Email/Password");
		return "redirect:/";
	}
}
