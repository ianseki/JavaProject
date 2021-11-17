package com.ian.javaBeltExam.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ian.javaBeltExam.models.User;
import com.ian.javaBeltExam.repositories.UserRepository;

@Component
public class UserValidator implements Validator
{
	
	private UserRepository uRepo;
	
	public UserValidator(UserRepository uRepo)
	{
		this.uRepo = uRepo;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		// TODO Auto-generated method stub
		User user = (User) target;
		
		if(this.uRepo.findByEmail(user.getEmail()) != null)
		{
        	errors.rejectValue("email", "Unique", "Email must be unique");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword()))
        {
            errors.rejectValue("passwordConfirmation", "Match", "Passwords do not match.");
        }
	}
}
