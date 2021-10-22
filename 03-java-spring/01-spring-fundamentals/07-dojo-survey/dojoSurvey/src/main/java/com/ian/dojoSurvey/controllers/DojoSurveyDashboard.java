package com.ian.dojoSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyDashboard 
{
	@GetMapping("/")
	public String survey()
	{
		return "survey.jsp";
	}
	
	@PostMapping("/submit")
	public String surveySubmit(@RequestParam("name") String name, 
			@RequestParam("location") String location,
			@RequestParam("language") String language,
			@RequestParam("comments") String comments,
			Model model,
			HttpSession session)
	{
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comments", comments);
		
		return "result.jsp";
	}
}
