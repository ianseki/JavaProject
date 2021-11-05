package com.ian.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ian.dojos_and_ninjas.models.Ninja;
import com.ian.dojos_and_ninjas.repositories.NinjaRepository;


@Service
public class NinjaService 
{
	private NinjaRepository nRepo;
	
	public NinjaService(NinjaRepository nRepo)
	{
		this.nRepo = nRepo;
	}
	
	public List<Ninja> allNinjas()
	{
		return nRepo.findAll();
	}
	
	public Ninja findNinja(Long id)
	{
		return this.nRepo.findById(id).orElse(null);
	}
	
	public Ninja createNinja(Ninja newDojo)
	{
		return this.nRepo.save(newDojo);
	}
	
	public Ninja updateNinja(Ninja updateDojo)
	{
		return this.nRepo.save(updateDojo);
	}
	
	public void deleteNinja(Long id)
	{
		this.nRepo.deleteById(id);
	}
}
