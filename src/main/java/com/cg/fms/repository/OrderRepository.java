package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Orders;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findAll(int customerId);
	
	
    

	

	
}