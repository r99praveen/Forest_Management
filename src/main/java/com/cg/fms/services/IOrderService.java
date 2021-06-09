package com.cg.fms.services;


import com.cg.fms.exception.OrderNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Order;

@Service
public interface IOrderService {

	
	
	Order fetchById(int ordernumber) throws OrderNotFoundException;
	
	
	Order addOrder(Order order);
	
	
	void  updateOrder(Order order);
	
	
	void delOrder(int ordernumber) throws OrderNotFoundException;
	
	
	List<Order> fetchAll();
}