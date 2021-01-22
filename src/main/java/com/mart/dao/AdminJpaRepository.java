package com.mart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mart.entity.Admin;

public interface AdminJpaRepository extends JpaRepository<Admin, Integer>
{
	Admin findByadname(String adname);
}