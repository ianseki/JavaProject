package com.ian.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@RequestMapping("/")
	public String Hello()
	{
		return "Hello Client! Hope you're having a good day today.";
	}
	
	@RequestMapping("/random")
	public String random()
	{
		return "This is a random compliment but I believe that Spring Boot is pretty great!";
	}
}
