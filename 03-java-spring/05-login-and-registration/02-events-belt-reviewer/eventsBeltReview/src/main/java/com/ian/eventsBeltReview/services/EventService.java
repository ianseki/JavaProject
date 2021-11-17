package com.ian.eventsBeltReview.services;

import java.util.List;

import com.ian.eventsBeltReview.models.Event;
import com.ian.eventsBeltReview.models.Message;
import com.ian.eventsBeltReview.models.User;
import com.ian.eventsBeltReview.repositories.EventRepository;
import com.ian.eventsBeltReview.repositories.MessageRepository;

public class EventService 
{
	private EventRepository eRepo;
	private MessageRepository mRepo;
	
	public EventService(EventRepository eRepo, MessageRepository mRepo)
	{
		this.eRepo = eRepo;
		this.mRepo = mRepo;
	}
	
	public List<Event> allEventsWithState(String state) 
	{
		return this.eRepo.findByState(state);
	}
	
	public List<Event> allEventsNotState(String state) 
	{
		return this.eRepo.findByStateIsNot(state);
	}
	
	public Event findById(Long id) 
	{
		return this.eRepo.findById(id).orElse(null);
	}
	
	public Event create(Event event) 
	{
		return this.eRepo.save(event);
	}
	
	public Event update(Event event) 
	{
		return this.eRepo.save(event);
	}
	
	public void comment(User user, Event event, String comment) 
	{
		this.mRepo.save(new Message(user, event, comment));
	}
	
	public void delete(Long id) 
	{
		this.eRepo.deleteById(id);
	}
	
	public void manageAttendees(Event event, User user, boolean isJoining) 
	{
		if(isJoining) 
		{
			event.getAttendees().add(user);
		}
		else 
		{
			event.getAttendees().remove(user);
		}
		
		this.eRepo.save(event);
	}
}
