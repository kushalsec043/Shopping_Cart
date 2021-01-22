package com.mart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mart.entity.Ingredient;
import com.mart.entity.Product;

public interface IngredientJpaRepository extends JpaRepository<Ingredient, Integer>
{
	
}
