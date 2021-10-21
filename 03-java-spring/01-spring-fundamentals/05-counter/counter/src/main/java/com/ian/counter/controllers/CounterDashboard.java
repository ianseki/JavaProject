package com.ian.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterDashboard 
{
	@RequestMapping("/")
	public String redirectingHome()
	{
		return "redirect:/your_server";
	}
	
	@RequestMapping("/your_server")
	public String home(HttpSession session)
	{
		if (session.getAttribute("count") == null)
		{
			session.setAttribute("count", 0);
		}
		else
		{
			int countInc = (int) session.getAttribute("count");
			countInc += 1;
			
			session.setAttribute("count", countInc);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/your_server/counter")
	public String counter(HttpSession session, Model model)
	{
		Integer currentCount = (Integer) session.getAttribute("count");
		if (currentCount == null)
		{
			model.addAttribute("showCurrentCount", 0);
		}
		else
		{
			model.addAttribute("showCurrentCount", currentCount);
		}
		
		return "count.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session)
	{
		session.setAttribute("count", 0);
		return "redirect:/your_server/counter";
	}
}
