package com.mart.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mart.dao.AdminJpaRepository;
import com.mart.entity.Admin;

@Service
public class AdminService 
{
	@Autowired
	AdminJpaRepository repo;
	
	@Autowired
	Admin ad;

	public boolean validate(String uname, String password) 
	{
		ad = null;
		ad = repo.findByadname(uname);
		
		if(ad != null)
		{
		if(ad.getAdname().equals(uname) && ad.getAdpass().equals(password))
		{
			return true;
		}
		}
		return false;
	}

}
