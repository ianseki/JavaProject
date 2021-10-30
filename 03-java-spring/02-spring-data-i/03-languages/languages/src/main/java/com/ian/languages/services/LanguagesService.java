package com.ian.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ian.languages.models.Languages;
import com.ian.languages.repositories.LanguagesRepository;

@Service
public class LanguagesService 
{
	private LanguagesRepository lRepo;

	public LanguagesService(LanguagesRepository lRepo) {
		this.lRepo = lRepo;
	}
	
	public List<Languages> allLanguages()
	{
		return lRepo.findAll();
	}
	
	public Languages findLanguage(Long id)
	{
		return this.lRepo.findById(id).orElse(null);
	}
	
	public Languages createLanguage(Languages newLanguage)
	{
		return this.lRepo.save(newLanguage);
	}
	
	public Languages updateLanguage(Languages updateLanguage)
	{
		return this.lRepo.save(updateLanguage);
	}
	
	public void deleteLanguage(Long id)
	{
		this.lRepo.deleteById(id);
	}
}
