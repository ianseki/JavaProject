package com.ian.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ian.dojos_and_ninjas.models.Dojo;
import com.ian.dojos_and_ninjas.models.Ninja;
import com.ian.dojos_and_ninjas.services.DojoService;
import com.ian.dojos_and_ninjas.services.NinjaService;

@Controller
public class NinjaController 
{
	private NinjaService nService;
	private DojoService dService;
	
	public NinjaController(NinjaService nService, DojoService dService)
	{
		this.nService = nService;
		this.dService = dService;
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(
			@ModelAttribute("newNinja") Ninja ninja,
			Model model)
	{
		List<Dojo> allDojos = this.dService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "/ninja/ninja.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(
			@Valid @ModelAttribute("newNinja") Ninja newNinja,
			BindingResult errorMessage,
			Model model)
	{
		if (errorMessage.hasErrors())
		{
			List<Dojo> allDojos = this.dService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "/ninja/ninja.jsp";
		}
		this.nService.createNinja(newNinja);
		return "redirect:/dojo/show/"+newNinja.getDojo().getId();
	}
}
