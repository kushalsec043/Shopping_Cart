package com.mart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mart.entity.Orders;

public interface OrdersJpaRepository extends JpaRepository<Orders, Integer>
{

}
