package com.cg.fms.services;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.OrderNotFoundException;
import com.cg.fms.entities.Orders;
import com.cg.fms.repository.OrderRepository;
import org.slf4j.LoggerFactory;


@Service
public class OrderServiceImpl implements IOrderService{
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository repository;// repository is a dependency of ProductServiceImpl

	
	@Override
	public Orders getOrder(int orderNumber) throws OrderNotFoundException {
		Optional<Orders> order = repository.findById(orderNumber);
		if (!order.isPresent())
			throw new OrderNotFoundException();
		return order.get();
	}
	
	
	// add a product //
	
	@Override
	public Orders addOrder(Orders order) {
		logger.info("inside addOrder method of OrderServiceImpl");
		return repository.save(order);
	}
	
	
	
	@Override
	public Orders updateOrder(Orders order) {
		return repository.save(order);
	}
	
	
	
	@Override
	public void delOrder(int orderNumber) throws OrderNotFoundException {
		Optional<Orders> order = repository.findById(orderNumber);
		if (!order.isPresent())
			throw new OrderNotFoundException();

		 repository.deleteById(orderNumber);
	
	}


	@Override
	public List<Orders> findAllOrders(int customerId) {
		return repository.findAll(customerId);
	}
		

	
	}

