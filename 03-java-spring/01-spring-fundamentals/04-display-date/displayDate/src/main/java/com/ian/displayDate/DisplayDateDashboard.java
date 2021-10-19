package com.ian.displayDate;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateDashboard 
{
	private Date getDate()
	{
		Date currentDate = new Date();
		
		return currentDate;
	}
	
	@RequestMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model)
	{
		model.addAttribute("dateTime", getDate());
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model)
	{
		model.addAttribute("dateTime", getDate());
		return "time.jsp";
	}
}
