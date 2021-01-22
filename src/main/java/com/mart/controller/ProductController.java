package com.mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mart.dao.IngredientJpaRepository;
import com.mart.dao.ProductJpaRepository;
import com.mart.entity.Ingredient;
import com.mart.entity.Product;


@Controller
public class ProductController
{
		String product_name = "";
		
		int product_counter = 1;
		int ingrd_counter = 1;
		
		@Autowired
		IngredientJpaRepository reposit;
	
		@Autowired
		ProductJpaRepository repo;
		
		@Autowired
		Product pro;
		
		@Autowired
		Product product;
		
		@Autowired
		Ingredient ingrd;
		
		// ADD TO REPOOO
		@RequestMapping(value = "/addcontrol", method=RequestMethod.GET)
		public String addproduct()
		{
			return "addproduct";
		}
		
		@RequestMapping(value = "/addtorepo", method=RequestMethod.POST)
		public String productadded(@RequestParam String pname,@RequestParam double pprice,@RequestParam String pimage, ModelMap model)
		{
			boolean reply = repo.existsBypname(pname);
					
			if(reply == false)
			{
			pro.setPid(product_counter);
			pro.setPname(pname);
			pro.setPprice(pprice);
			pro.setPimage(pimage);
			
			product_name = pname;
			
			repo.save(pro);
			product_counter++;
			
			model.put("ProductMessage","You Added " + pname +" to FoodCart Repository!!!");
			model.put("addingredient","Try adding some Ingredients!!!");
			
			return "addproduct";
			}
			
			model.put("ProductMessage","You have already added this item!!!");
			return "addproduct";
		}
		
		@RequestMapping(value = "/addingredients", method=RequestMethod.POST)
		public String ingredientsadded(@RequestParam String ingname, @RequestParam String ingimage, ModelMap model)
		{
			product = repo.findBypname(product_name);
			
			ingrd.setIngid(ingrd_counter);
			ingrd.setIngname(ingname);
			ingrd.setIngimage(ingimage);
			reposit.save(ingrd);
					
			if(product.getIngred().contains(ingrd))
			{
				model.put("IngredientMessage","You have already added this Ingredient!!!");
				return "addproduct";
			}
			else
			{
				product.getIngred().add(ingrd);
				repo.save(product);
				ingrd_counter++;
				
				model.put("IngredientMessage","You added an Ingredient :- " + ingname + "!!!");
				return "addproduct";
			}
		}
		
		//UPDATE REPOOO
		@RequestMapping(value = "/updatecontrol", method=RequestMethod.GET)
		public String updateproduct()
		{
			return "updateproduct";
		}

		
		@RequestMapping(value = "/updatetorepo", method=RequestMethod.POST)
		public String productupdated(@RequestParam int pid,Product product, ModelMap model)
		{
			boolean exist = repo.existsById(pid);
		
			if(!exist)
			{
				model.put("IdMessage", "Enter a Valid Product Info.!!!");
				return "updateproduct";
			}
			
			repo.deleteById(pid);
			
			model.put("ProductMessage","You Updated a Product from Mart Repository!!!");
			repo.save(product);
			
			return "products";
		}
		
		//REMOVE REPOOO
		@RequestMapping(value = "/removecontrol", method=RequestMethod.GET)
		public String removeproduct()
		{
			return "removeproduct";
		}
		
		@RequestMapping(value = "/removerepo", method=RequestMethod.POST)
		public String productremoved(@RequestParam int pid,Product product, ModelMap model)
		{
			pro = repo.findById(pid).orElse(null);
			
			if(pro != null)
			{
			model.put("ProductMessage","You Removed a Product from Mart Repository!!!");
			repo.delete(pro);
			return "products";
			}
			else
			{
			model.put("IdMessage", "Enter a Valid ID!!!");
			return "removeproduct";
			}
		}
	}

