package com.cg.fms.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.exception.OrderNotFoundException;
import com.cg.fms.entities.Order;
import com.cg.fms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository repository;

	

	
	@Override
	public Order fetchById(int ordernumber) throws OrderNotFoundException {
		Optional<Order> order = repository.findById(ordernumber);
		if (!order.isPresent())
			throw new OrderNotFoundException();
		return order.get();
	}
	
	
	
	
	@Override
	public Order addOrder(Order order) {
		logger.info("inside addOrder method of OrderServiceImpl");
		return repository.save(order);
		
		
	}
	
	
	
	
	@Override
	public void updateOrder(Order order) {
		repository.save(order);
	}
	
	
	
	
	@Override
	public void delOrder(int ordernumber) throws OrderNotFoundException {
		Optional<Order> order = repository.findById(ordernumber);
		if (!order.isPresent())
			throw new OrderNotFoundException();

		repository.deleteById(ordernumber);
	}
		
	
	
	
	@Override
	public List<Order> fetchAll() {
		return repository.findAll();
	}
}
