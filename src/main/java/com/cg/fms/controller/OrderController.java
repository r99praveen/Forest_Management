package com.cg.fms.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.fms.services.IOrderService;
import com.cg.fms.entities.Orders;
import com.cg.fms.exception.OrderNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {

	
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService service;
	
	
	@GetMapping("/getById/{orderNumber}")
	@ApiOperation("Get Order By orderNumber")
	public Orders getOrder(@PathVariable int orderNumber) throws OrderNotFoundException {
		logger.info("Inside fetchById %s", orderNumber);
		return service.getOrder(orderNumber);
	}
		
		
	@PostMapping("/save")
	@ApiOperation("Place a new order")
	public ResponseEntity<Orders> save(@Valid @RequestBody Orders order) {
		logger.info("Adding a order : " + order);
		Orders ord = service.addOrder(order);
		return new ResponseEntity<>(ord, HttpStatus.CREATED);
	}
	
	//update a Order
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing Order")
	public void update(@Valid @RequestBody Orders order) {
		logger.info("Updating a order!!");
		service.updateOrder(order);
	}

	
	@DeleteMapping("/delete/{orderNumber}")
	@ApiOperation("Delete an Existing Order")
	public ResponseEntity<Void> delete(@PathVariable int orderNumber) throws OrderNotFoundException {
		logger.info("Deleting a order!!");
		service.delOrder(orderNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all order Details")
	public List<Orders> findAllOrders(@PathVariable int customerId) {
	logger.info("Fetching all order!");
	return service.findAllOrders(customerId);
	}
}
	


	
