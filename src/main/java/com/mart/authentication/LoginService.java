package com.mart.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.UserJpaRepository;
import com.mart.entity.User;

@Service
public class LoginService 
{
	@Autowired
	UserJpaRepository repo;
	
	@Autowired
	User u;

	public boolean validateUser(String uname, String password) 
	{
		u = null;
		u = repo.findByaname(uname);
		
		if(u != null)
		{
		if(u.getAname().equals(uname) && u.getPsw().equals(password))
		{
			return true;
		}
		}
		return false;
	}
	
	public void adduser(User user)
	{
		repo.save(user);
	}

}
