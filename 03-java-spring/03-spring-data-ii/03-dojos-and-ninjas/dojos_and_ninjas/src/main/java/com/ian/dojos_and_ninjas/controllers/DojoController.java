package com.ian.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ian.dojos_and_ninjas.models.Dojo;
import com.ian.dojos_and_ninjas.services.DojoService;

@Controller
public class DojoController 
{
	private DojoService dService;
	
	public DojoController(DojoService dService)
	{
		this.dService = dService;
	}
	
	@GetMapping("/")
	public String dashboard(
			@ModelAttribute("newDojo") Dojo newDojo,
			Model model)
	{
		model.addAttribute("allDojos", this.dService.allDojos());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String create(
			@Valid @ModelAttribute("newDojo") Dojo newDojo,
			BindingResult errorMessage,
			Model model)
	{
		if (errorMessage.hasErrors())
		{
			List<Dojo> allDojos = this.dService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "index.jsp";
		}
		this.dService.createDojo(newDojo);
		return "redirect:/dojo/show/"+newDojo.getId();
	}
	
	@GetMapping("/dojo/show/{id}")
	public String dojoNinjas(
			@PathVariable("id") Long id,
			Model model)
	{
		model.addAttribute("dojoId", this.dService.findDojo(id));
		return "/dojo/dojo.jsp";
	}
}
