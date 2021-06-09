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
import com.cg.fms.entities.Order;
import com.cg.fms.exception.OrderNotFoundException;
import com.cg.fms.services.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService service;
	
	
	
	
	
	@GetMapping("/getById/{ordernumber}") 
	@ApiOperation("Get Order By OrderNumber")
	public Order fetchById(@PathVariable int ordernumber) throws OrderNotFoundException {
		logger.info("Inside fetchById %s", ordernumber);
		return service.fetchById(ordernumber);
	}
		
	
		
		
	@PostMapping("/save")
	@ApiOperation("Add a new Order")
	public ResponseEntity<Order> save(@Valid @RequestBody Order order) {
		logger.info("Adding a order : " + order);
		Order ord = service.addOrder(order);
		return new ResponseEntity<>(ord, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing Order")
	public void update(@Valid @RequestBody Order order) {
		logger.info("Updating a order details!!");
		service.updateOrder(order);
	}
	
	
	
	
	@DeleteMapping("/delete/{ordernumber}")
	@ApiOperation("Delete an Existing Order")
	public ResponseEntity<Void> delete(@PathVariable int ordernumber) throws OrderNotFoundException {
		logger.info("Deleting a Order!!");
		service.delOrder(ordernumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	// get all product
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Order Details")
	public List<Order> fetch() {
	logger.info("Fetching all Orders!");
	return service.fetchAll();
	}
	
}

	
	
	
