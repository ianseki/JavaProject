package com.ian.javaBeltExam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ian.javaBeltExam.models.Idea;
import com.ian.javaBeltExam.models.User;
import com.ian.javaBeltExam.repositories.IdeaRepository;

@Service
public class IdeaService 
{
	private IdeaRepository iRepo;
	
	public IdeaService(IdeaRepository iRepo)
	{
		this.iRepo = iRepo;
	}
	
	public List<Idea> allIdeas()
	{
		return this.iRepo.findAll();
	}
	
	public Idea findById(Long id)
	{
		return this.iRepo.findById(id).orElse(null);
	}
	
	public Idea createIdea(Idea idea)
	{
		return this.iRepo.save(idea);
	}
	
	public Idea updateIdea(Idea idea)
	{
		return this.iRepo.save(idea);
	}
	
	public void deleteIdea(Long id)
	{
		this.iRepo.deleteById(id);
	}
	
	public void addLikes(User user, Idea idea) 
	{
		List<User> likes = idea.getPeopleWhoLikedIdea();
		likes.add(user);
		iRepo.save(idea);
	}
	
	public void removeLikes(User user, Idea idea)
	{
		List<User> likes = idea.getPeopleWhoLikedIdea();
		if(likes.contains(user))
		{
			likes.remove(user);
		}
		iRepo.save(idea);
	}
}
