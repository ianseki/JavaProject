package com.ian.eventsBeltReview.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ian.eventsBeltReview.models.User;
import com.ian.eventsBeltReview.repositories.UserRepository;

@Service
public class UserService 
{
	private UserRepository uRepo;
	
	public UserService(UserRepository uRepo)
	{
		this.uRepo = uRepo;
	}
	
	public User findById(Long id) 
	{
		return this.uRepo.findById(id).orElse(null);
	}
	
	public User registerUser(User user) 
	{
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
	
	public User getUserByEmail(String email) 
	{
		return this.uRepo.findByEmail(email);
	}
	
	public boolean authenticateUser(String email, String password) 
	{
		User user = this.uRepo.findByEmail(email);
		if(user == null)
			return false;
		
		return BCrypt.checkpw(password, user.getPassword());
	}
}
