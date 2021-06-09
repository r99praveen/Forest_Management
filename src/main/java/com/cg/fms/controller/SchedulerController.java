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

import com.cg.fms.services.ISchedulerservice;
import com.cg.fms.entities.Scheduler;
import com.cg.fms.exception.InvalidSchedulerException;
import com.cg.fms.exception.SchedulerNotFoundExcption;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedulers")
public class SchedulerController {

	
	Logger logger = LoggerFactory.getLogger(SchedulerController.class);
	
	@Autowired
	private ISchedulerservice service;
	
	
	//get scheduler (by id)//
	
	@GetMapping("/getById/{schedulerId}")
	@ApiOperation("Get scheduler By schedulerId")
	public Scheduler fetchById(@PathVariable int schedulerId) throws SchedulerNotFoundExcption {
		logger.info("Inside fetchById %s", schedulerId);
		return service.fetchById(schedulerId);
	}
		
	
		// adding a product//
		
	@PostMapping("/save")
	@ApiOperation("Add a new scheduler")
	public ResponseEntity<Scheduler> save(@Valid @RequestBody Scheduler scheduler) {
		logger.info("Adding a scheduler : " + scheduler);
		Scheduler sch = service.addScheduler(scheduler);
		return new ResponseEntity<>(sch, HttpStatus.CREATED);
	}
	
	
	//update a scheduler
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing scheduler")
	public void update(@Valid @RequestBody Scheduler scheduler) {
		logger.info("Updating a scheduler!!");
		service.updateScheduler(scheduler);
	}
	
	
	//deleting a product(by id)
	
	@DeleteMapping("/delete/{schedulerId}")
	@ApiOperation("Delete an Existing schedulerId")
	public ResponseEntity<Void> delete(@PathVariable int schedulerId) throws  SchedulerNotFoundExcption {
		logger.info("Deleting a scheduler!!");
		service.delScheduler(schedulerId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all scheduler Details")
	public List<Scheduler> fetch() {
		logger.info("Fetching all Orders!");
		return service.fetchAll();
	}
	
}

/*package com.cg.fms.controller;
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

	
	
	
*/	
