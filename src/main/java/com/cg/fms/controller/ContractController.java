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

import com.cg.fms.entities.Contract;
import com.cg.fms.entities.Order;
import com.cg.fms.exception.ContractNotFoundException;
import com.cg.fms.exception.OrderNotFoundException;
import com.cg.fms.services.IContractService;
import com.cg.fms.services.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contracts")
public class ContractController {

	Logger logger = LoggerFactory.getLogger(ContractController.class);
	
	@Autowired
	private IContractService service;
	
	
	
	
	
	@GetMapping("/getById/{contractnumber}") 
	@ApiOperation("Get contract details By ContractNumber")
	public Contract fetchById(@PathVariable int contractnumber) throws ContractNotFoundException {
		logger.info("Inside fetchById %s", contractnumber);
		return service.fetchById(contractnumber);
	}
		
	
		
		
	@PostMapping("/save")
	@ApiOperation("Add a new contract")
	public ResponseEntity<Contract> save(@Valid @RequestBody Contract contract) {
		logger.info("Adding a contract : " + contract);
		Contract con = service.addContract(contract);
		return new ResponseEntity<>(con, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing Contract")
	public void update(@Valid @RequestBody Contract contract) {
		logger.info("Updating a contract details!!");
		service.updateContract(contract);
	}
	
	
	
	
	@DeleteMapping("/delete/{contractnumber}")
	@ApiOperation("Delete an Existing Contract")
	public ResponseEntity<Void> delete(@PathVariable int contractnumber) throws ContractNotFoundException {
		logger.info("Deleting a Contract!!");
		service.delContract(contractnumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Contract Details")
	public List<Contract> fetch() {
	logger.info("Fetching all Contracts!");
	return service.fetchAll();
	}
	
}
