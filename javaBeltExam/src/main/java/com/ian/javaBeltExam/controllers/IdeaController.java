package com.ian.javaBeltExam.controllers;

import javax.servlet.http.HttpSession;
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

import com.ian.javaBeltExam.models.Idea;
import com.ian.javaBeltExam.models.User;
import com.ian.javaBeltExam.services.IdeaService;
import com.ian.javaBeltExam.services.UserService;

@Controller
public class IdeaController 
{
	private IdeaService iService;
	private UserService uService;
	
	public Long sessionUserId(HttpSession session)
	{
		if (session.getAttribute("userId") == null)
		{
			return null;
		}
		return (Long)session.getAttribute("userId");
	}
	
	public IdeaController(IdeaService iService, UserService uService)
	{
		this.iService = iService;
		this.uService = uService;
	}
	
	@GetMapping("/ideas")
	public String userHome(
			@ModelAttribute("idea") Idea idea,
			Model model,
			HttpSession session)
	{
		Long userId = this.sessionUserId(session);
		User user = this.uService.findById(userId);
		
		model.addAttribute("allIdeas", this.iService.allIdeas());
		model.addAttribute("user", user);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/ideas/new")
	public String newIdea(
			@ModelAttribute("newIdea") Idea newIdea,
			HttpSession session,
			Model model)
	{
		Long userId = this.sessionUserId(session);
		User user = this.uService.findById(userId);
		
		model.addAttribute("user", user);
		return "newIdea.jsp";
	}
	
	@PostMapping("/ideas/create")
	public String createIdea(
			@Valid @ModelAttribute("newIdea") Idea newIdea,
			BindingResult errorMessage,
			HttpSession session,
			Model model)
	{
		if (errorMessage.hasErrors())
			{
				Long userId = this.sessionUserId(session);
				User user = this.uService.findById(userId);
				
				model.addAttribute("allIdeas", this.iService.allIdeas());
				model.addAttribute("user", user);
				
				return "newIdea.jsp";
			}
		
		this.iService.createIdea(newIdea);
		return "redirect:/ideas";
	}
	
	@GetMapping("/ideas/{id}/like")
	public String likeIdea(
			@PathVariable("id") Long id,
			HttpSession session)
	{
		Long userId = this.sessionUserId(session);
		User user = this.uService.findById(userId);
		Idea idea = this.iService.findById(id);
		
		iService.addLikes(user, idea);
		
		return "redirect:/ideas";
	}
	
	@GetMapping("/ideas/{id}/dislike")
	public String disLikeIdea(
			@PathVariable("id") Long id,
			HttpSession session)
	{
		Long userId = this.sessionUserId(session);
		User user = this.uService.findById(userId);
		Idea idea = this.iService.findById(id);
		
		iService.removeLikes(user, idea);
		
		return "redirect:/ideas";
	}
	
	@GetMapping("/ideas/{id}")
	public String showIdea(
			@PathVariable("id") Long id,
			HttpSession session,
			Model model)
	{
		Idea idea = this.iService.findById(id);
		Long userId = this.sessionUserId(session);
		
		model.addAttribute("idea", idea);
		model.addAttribute("userId", userId);
		
		return "showIdea.jsp";
	}
	
	@GetMapping("/ideas/{id}/edit")
	public String editIdea(
			@PathVariable("id") Long id,
			HttpSession session,
			Model model)
	{
		Long userId = this.sessionUserId(session);
		Idea idea = this.iService.findById(id);
		
		if(userId == null)
		{
			return "redirect:/";
		}
		
		if(idea == null || !idea.getCreator().getId().equals(userId))
		{
			return "redirect:/ideas";
		}
		
		model.addAttribute("editIdea", idea);
		model.addAttribute("userId", userId);
		
		return "editIdea.jsp";
	}
	
	@PutMapping("/ideas/{id}/edit")
	public String submitEditIdea(
			@Valid @ModelAttribute("editIdea") Idea editIdea,
			@PathVariable("id") Long id,
			BindingResult errorMessage,
			HttpSession session,
			Model model)
	{	
		if (errorMessage.hasErrors())
		{	
			Long userId = this.sessionUserId(session);
			
			model.addAttribute("editIdea", editIdea);
			model.addAttribute("userId", userId);
			
			return "editIdea.jsp";
		}
		this.iService.updateIdea(editIdea);
		return "redirect:/ideas";
	}
	
	@DeleteMapping("/ideas/{id}/delete")
	public String deleteIdea(@PathVariable("id") Long id)
	{
		this.iService.deleteIdea(id);
		return "redirect:/ideas";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) 
	{
		session.invalidate();
		return "redirect:/";
	}
}
