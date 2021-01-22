package com.mart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mart.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer>
{
	Product findBypname(String pname);
	
	Product findBypid(int pid);
	
	boolean existsBypname(String pname);
}
