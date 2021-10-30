package com.ian.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ian.languages.models.Languages;
import com.ian.languages.services.LanguagesService;

@Controller
public class LanguagesDashboard 
{
	private LanguagesService lService;
	
	public LanguagesDashboard(LanguagesService service)
	{
		this.lService = service;
	}
	
	@GetMapping("/")
	public String mainPage(
			@ModelAttribute("newLanguage") Languages newLang,
			Model model)
	{	
		model.addAttribute("allLanguages", this.lService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String create(
			@Valid @ModelAttribute("newLanguage") Languages newLang,
			BindingResult errorMessage,
			Model model)
	{
		if (errorMessage.hasErrors())
		{
			List<Languages> allLanguages = this.lService.allLanguages();
			model.addAttribute("allLanguages", allLanguages);
			return "index.jsp";
		}
		this.lService.createLanguage(newLang);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model)
	{
		model.addAttribute("langID", this.lService.findLanguage(id));
		return "results.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model)
	{
		model.addAttribute("langID", this.lService.findLanguage(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editPut(
			@Valid @ModelAttribute("language") Languages language,
			BindingResult errorMessage,
			Model model,
			Long id)
	{
		if (errorMessage.hasErrors())
		{
			model.addAttribute("language", this.lService.findLanguage(id));
			return "edit.jsp";
		}
		this.lService.updateLanguage(language);
		return "redirect:/show/{id}";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		this.lService.deleteLanguage(id);
		return "redirect:/";
	}
	
	
}
