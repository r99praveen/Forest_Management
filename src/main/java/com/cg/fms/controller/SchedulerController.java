package com.cg.fms.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.fms.entities.Scheduler;
import com.cg.fms.exception.SchedulerNotFoundExcption;
import com.cg.fms.services.ISchedulerservice;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

	
	Logger logger = LoggerFactory.getLogger(SchedulerController.class);
	
	@Autowired
	private ISchedulerservice service;
	
	
	//get scheduler (by id)//
	
	@GetMapping("getById/{schedulerId}")
	@ApiOperation("Get scheduler By schedulerId")
	public Scheduler fetchById(@PathVariable String schedulerId) throws SchedulerNotFoundExcption {
		logger.info("Inside fetchById %s", schedulerId);
		System.out.println(schedulerId);
		return service.fetchById(Integer.valueOf(schedulerId));
		
	}
		
	
		// adding a product//
		
	@PostMapping("save")
	@ApiOperation("Add a new scheduler")
	public ResponseEntity<Scheduler> save(@Valid @RequestBody Scheduler scheduler) {
		logger.info("Adding a scheduler : " + scheduler.getTruckNumber());
		Scheduler sch = service.addScheduler(scheduler);
		return new ResponseEntity<>(sch, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing scheduler")
	public void update(@Valid @RequestBody Scheduler scheduler) {
		logger.info("Updating a scheduler!!");
		service.updateScheduler(scheduler);
	}
	
	
	
	
	@DeleteMapping("/delete/{schedulerId}")
	@ApiOperation("Delete an Existing schedulerId")
	public ResponseEntity<Void> delete(@PathVariable int schedulerId) throws SchedulerNotFoundExcption {
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