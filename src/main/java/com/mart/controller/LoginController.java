package com.mart.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mart.authentication.AdminService;
import com.mart.authentication.LoginService;
import com.mart.dao.ProductJpaRepository;
import com.mart.dao.UserJpaRepository;
import com.mart.entity.Product;
import com.mart.entity.User;


@Controller
public class LoginController
{
	@Autowired
	LoginService service;
	
	@Autowired
	UserJpaRepository userrepo;
	
	@Autowired
	ProductJpaRepository productrepo;
	
	@Autowired
	AdminService admin;
	
	@Autowired
	List<Product> pro;
	
	@Autowired
	User user;
	
	@Autowired
	User new_user;
	
	@RequestMapping(value = "/welcome", method=RequestMethod.GET)
	public ModelAndView welcomepage(ModelMap model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String LoginPage(ModelMap model)
	{
		model.put("errorMessage", "Login if your a member / Else Sign Up");
		return "login";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String SignUpPage()
	{
		return "signup";
	}
	
	@RequestMapping(value = "/signedup", method=RequestMethod.POST)
	public String SignedUp(@RequestParam String aname,@RequestParam String psw,@RequestParam String email, User user, ModelMap model)
	{
		user = userrepo.findByaname(aname);
		
		if(user == null)
		{
			// Insert Data to database
			new_user.setAname(aname);
			new_user.setPsw(psw);
			new_user.setEmail(email);
			
			service.adduser(new_user);
			model.put("errorMessage","You're Signed In!! Login Now");
			return "login";
		}
		
		model.put("alreadysigned", "You are already a registered user!!! Back to Login");
		return "signup";
	}
	
	@RequestMapping(value = "/homepage", method=RequestMethod.POST)
	public String handleloginrequest(
			@RequestParam String aname,
			@RequestParam String psw, 
			ModelMap model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		if(service.validateUser(aname, psw))
		{
		model.put("aname", aname);
		model.put("psw", psw);
		
		session.setAttribute("username", aname);
		
		// Resolve it to view using viewresolver....
		pro = productrepo.findAll();
		session.setAttribute("product", pro);
		
		return "homepage";
		}
		else
		{
			model.put("errorMessage","Invalid Credentials / Sign Up if not a member");
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public String adminpage(ModelMap model)
	{
		model.put("adminmessage", "Need Authorization to customize homepage!!!");
		return "adminpage";
	}
	
	@RequestMapping(value = "/admintoproduct", method=RequestMethod.POST)
	public String adminpagetoproducts(@RequestParam String adname,
		@RequestParam String adpass, 
		ModelMap model, HttpSession session) throws ClassNotFoundException, SQLException
	{
	if(admin.validate(adname, adpass))
	{
	return "products";
	}
	else
	{
		model.put("adminmessage","Invalid Credentials / Get a Valid Admin UserName & PassWord");
		return "adminpage";
	}
	}
	
	@RequestMapping(value = "/homepage", method=RequestMethod.GET)
	public String homepage(HttpSession session, ModelMap model)
	{
		// Resolve it to view using viewresolver....
		model.put("getid", "");
		
		pro = productrepo.findAll();
		session.setAttribute("product", pro);
		return "homepage";
	}
	
	@RequestMapping(value = "/homepagegetid", method=RequestMethod.GET)
	public String homepagegetid(HttpSession session, ModelMap model)
	{
		// Resolve it to view using viewresolver....
		model.put("getid", "ID on top of the product!!! Please Refer.");
		
		pro = productrepo.findAll();
		session.setAttribute("product", pro);
		return "homepage";
	}
	
	
}
