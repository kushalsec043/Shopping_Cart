package com.mart.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	@ManyToMany
	public Set<Product> cart = new HashSet<Product>();
	
	@ManyToMany
	public Set<Orders> order = new HashSet<Orders>();
	
	private String aname;
	private String psw;
	private String email;
	
	@Override
	public String toString() {
		return "User [aid=" + aid + ", aname=" + aname + ", password=" + psw + ", email=" + email + "]";
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public Set<Orders> getOrder() {
		return order;
	}
	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	public Set<Product> getCart() {
		return cart;
	}
	public void setCart(Set<Product> cart) {
		this.cart = cart;
	}
	
	
}
