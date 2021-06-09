package com.cg.fms.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.exception.ContractNotFoundException;
import com.cg.fms.entities.Contract;
import com.cg.fms.repository.ContractRepository;

@Service
public class ContractServiceImpl implements IContractService{
	
	Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private ContractRepository repository;

	

	
	@Override
	public Contract fetchById(int contractnumber) throws ContractNotFoundException {
		Optional<Contract> contract = repository.findById(contractnumber);
		if (!contract.isPresent())
			throw new ContractNotFoundException();
		return contract.get();
	}
	
	
	
	
	@Override
	public Contract addContract(Contract contract) {
		logger.info("inside addContract method of ContractServiceImpl");
		return repository.save(contract);
		
		
	}
	
	
	
	
	@Override
	public void updateContract(Contract contract) {
		repository.save(contract);
	}
	
	
	
	
	@Override
	public void delContract(int contractnumber) throws ContractNotFoundException {
		Optional<Contract> contract = repository.findById(contractnumber);
		if (!contract.isPresent())
			throw new ContractNotFoundException();

		repository.deleteById(contractnumber);
	}
		
	
	
	
	@Override
	public List<Contract> fetchAll() {
		return repository.findAll();
	}
}