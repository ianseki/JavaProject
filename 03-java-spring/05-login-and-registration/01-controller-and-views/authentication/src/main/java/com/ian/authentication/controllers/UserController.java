package com.ian.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ian.authentication.models.User;
import com.ian.authentication.services.UserService;

@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	if (result.hasErrors())
    	{
    		return "registrationPage.jsp";
    	}
    	User newUser = this.userService.registerUser(user);
    	session.setAttribute("userId", newUser.getId());
    	return "redirect:/home";
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        Boolean authenticationCheck = userService.authenticateUser(email, password);
    	// if the user is authenticated, save their user id in session
    	
    	if (authenticationCheck)
    	{
    		User user = userService.findByEmail(email);
    		session.setAttribute("userId", user.getId());
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	else
    	{
    		model.addAttribute("error", "Invalid credentials. Please try again. ");
    		return "loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	// get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	User sessionUser = userService.findUserById(userId);
    	model.addAttribute("sessionUser", sessionUser);
    	return "homePage.jsp";
        
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}