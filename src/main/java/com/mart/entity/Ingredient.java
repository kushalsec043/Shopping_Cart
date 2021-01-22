package com.mart.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Ingredient 
{
	   @Id 
	   //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	   private int ingid;
	   
	   @ManyToMany(mappedBy="ingred")
	   public Set<Product> product = new HashSet<Product>();
	   
	   private String ingname;
	   private String ingimage;
	   
	public int getIngid() {
		return ingid;
	}
	public void setIngid(int ingid) {
		this.ingid = ingid;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public String getIngname() {
		return ingname;
	}
	public void setIngname(String ingname) {
		this.ingname = ingname;
	}
	public String getIngimage() {
		return ingimage;
	}
	public void setIngimage(String ingimage) {
		this.ingimage = ingimage;
	}
	
	   
}
