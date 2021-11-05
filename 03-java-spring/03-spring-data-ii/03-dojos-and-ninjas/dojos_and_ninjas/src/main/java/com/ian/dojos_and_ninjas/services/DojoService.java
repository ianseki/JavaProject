package com.ian.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ian.dojos_and_ninjas.models.Dojo;
import com.ian.dojos_and_ninjas.repositories.DojoRepository;



@Service
public class DojoService 
{
	private DojoRepository dRepo;
	
	public DojoService(DojoRepository dRepo) {
		this.dRepo = dRepo;
	}
	
	public List<Dojo> allDojos()
	{
		return dRepo.findAll();
	}
	
	public Dojo findDojo(Long id)
	{
		return this.dRepo.findById(id).orElse(null);
	}
	
	public Dojo createDojo(Dojo newDojo)
	{
		return this.dRepo.save(newDojo);
	}
	
	public Dojo updateDojo(Dojo updateDojo)
	{
		return this.dRepo.save(updateDojo);
	}
	
	public void deleteDojo(Long id)
	{
		this.dRepo.deleteById(id);
	}
}
