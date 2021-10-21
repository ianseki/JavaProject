package com.ian.familiarRouting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController 
{
	@RequestMapping("/dojo")
	public String dojo()
	{
		return "The dojo is awesome!";
	}
	
	@RequestMapping("/dojo/{location}")
	public String dojoLocation(@PathVariable("location") String location)
	{
		switch(location)
		{
			case "burbank":
				
				return "Burbank Dojo is located in Southern California";
			
			case "san-jose":
				
				return "SJ dojo is the headquarters";
				
			default:
				
				return String.format("%s dojo is awesome", location);
		}
		
	}
}
