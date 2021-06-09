package com.cg.fms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	
	
	
	//Order findById(int ordernumber);
	
	//Order fetchById(int ordernumber);
	
	
	//Order deleteById(int ordernumber);
	
	
		//boolean addOrder(boolean order);
		 
		 //boolean updateOrder(boolean order);
		 
		// boolean deleteOrder(boolean order);
		 
		 //List<Order> getAllOrders();
}
