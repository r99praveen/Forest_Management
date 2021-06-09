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

import com.cg.fms.services.IContractService;
import com.cg.fms.entities.Contract;
import com.cg.fms.exception.InvalidContractException;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/contracts")
public class ContractController {	
	
	Logger logger = LoggerFactory.getLogger(ContractController.class);
	
	@Autowired
	private IContractService service;
	
	
	
	@GetMapping("/getById/{contractNumber}")
	@ApiOperation("Get Contract By contractNumber")
	public Contract getContract(@PathVariable int contractNumber) throws  InvalidContractException {
		logger.info("Inside fetchById %s", contractNumber);
		return service.getContract(contractNumber);
	}
	
		
	@PostMapping("/save")
	@ApiOperation("Add a new contracter")
	public ResponseEntity<Contract> save(@Valid @RequestBody Contract contract) {
		logger.info("Adding a contract : " + contract);
		Contract cont = service.addContract(contract);
		return new ResponseEntity<>(cont, HttpStatus.CREATED);
	}
	
	
	//update a product
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing contract")
	public void update(@Valid @RequestBody Contract contract) {
		logger.info("Updating a contract!!");
		service.updateContract(contract);
	}
	
	
	//deleting a contract(by id)
	
	@DeleteMapping("/delete/{contractNumber}")
	@ApiOperation("Delete an Existing ContractNumber")
	public ResponseEntity<Void> delete(@PathVariable int contractNumber) throws  InvalidContractException {
		logger.info("Deleting a contract!!");
		service.delContract(contractNumber);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	// get all contract
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all contract Details")
	public List<Contract> getAllContracts() {
	logger.info("Fetching all contract details!");
	return service.getAllContracts();
	}
	
}

	
