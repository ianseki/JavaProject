package com.ian.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ian.languages.models.Languages;
import com.ian.languages.services.LanguagesService;

@RestController
public class APIController 
{
	@Autowired
	private LanguagesService lService;
	
	@GetMapping("/api/languages")
	public List<Languages> getLanguages()
	{
		return lService.allLanguages();
	}
	
	@PostMapping("/api/create")
	public Languages create(Languages newLanguage)
	{
		return lService.createLanguage(newLanguage);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public void delete(@PathVariable("id") Long id)
	{
		this.lService.deleteLanguage(id);
	}
}
