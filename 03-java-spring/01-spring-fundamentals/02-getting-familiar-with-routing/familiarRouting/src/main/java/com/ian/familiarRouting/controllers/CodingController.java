package com.ian.familiarRouting.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController 
{
	@RequestMapping(value={
			"/",
			"/coding"
			})
	public String home()
	{
		return "Hello Coding Dojo";
	}
	
	@RequestMapping("/coding/python")
	public String python()
	{
		return "Python/Flask was awesome!";
	}
	
	@RequestMapping("/coding/java")
	public String java()
	{
		return "Java/Spring is better!";
	}
}
