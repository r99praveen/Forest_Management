package com.cg.fms.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Contract;
import com.cg.fms.exception.InvalidContractException;
import com.cg.fms.repository.ContractRepository;

@Service
public class ContractServiceImpl implements IContractService{
	
	Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private ContractRepository repository;// repository is a dependency of ProductServiceImpl

	
	@Override
	public Contract getContract(int contractNumber) throws InvalidContractException {
		Optional<Contract> contract = repository.findById(contractNumber);
		if (!contract.isPresent())
			throw new InvalidContractException();
		return contract.get();
	}

	
	@Override
	public Contract addContract(Contract contract) {
		logger.info("inside addcontract method of ContractserviceImpl");
		return repository.save(contract);
	}
	
	
	@Override
	public Contract updateContract(Contract contract) {
		return repository.save(contract);
	}
	
	
	@Override
	public void delContract(int contractNumber) throws InvalidContractException {
		Optional<Contract> contractNum = repository.findById(contractNumber);
		if (!contractNum.isPresent())
			throw new InvalidContractException();

		 repository.deleteByContract(contractNumber);
	
	}	
		

	@Override
	public List<Contract> getAllContracts() {
		return repository.findAll();
	}


	
	
}
