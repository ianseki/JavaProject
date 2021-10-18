package com.ian.helloHuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController 
{
	@RequestMapping("/")
	public String root()
	{
		return "Hello Human";
	}
	
	@RequestMapping("/welcome")
	public String humanWelcome(@RequestParam(value="t") String firstName, String lastName)
	{
		return "Welcome " + firstName + " " + lastName;
	}
	
}
