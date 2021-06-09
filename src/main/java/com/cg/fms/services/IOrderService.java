package com.cg.fms.services;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Orders;
import com.cg.fms.exception.OrderNotFoundException;

@Service
public interface IOrderService {

	public Orders getOrder(int orderNumber) throws OrderNotFoundException;

	public Orders addOrder(Orders order);

	public void delOrder(int orderNumber) throws OrderNotFoundException;

	public Orders updateOrder( Orders orders);

	List<Orders> findAllOrders(int customerId);

	


	
}
