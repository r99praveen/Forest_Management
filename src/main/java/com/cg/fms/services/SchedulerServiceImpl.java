package com.cg.fms.services;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exception.SchedulerNotFoundExcption;
import com.cg.fms.entities.Scheduler;
import com.cg.fms.repository.SchedulerRepository;

import org.slf4j.LoggerFactory;

@Service
public class SchedulerServiceImpl implements ISchedulerservice{
	
	Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);
	
	@Autowired
	private SchedulerRepository repository;// repository is a dependency of ProductServiceImpl

	@Override
	public Scheduler fetchById(int schedulerId) throws SchedulerNotFoundExcption {
		Optional<Scheduler> contract = repository.findById(schedulerId);
		if (!contract.isPresent())
			throw new SchedulerNotFoundExcption();
		return contract.get();
	}

	@Override
	public void updateScheduler(Scheduler scheduler) {
		repository.save(scheduler);
		
	}

	@Override
	public void delScheduler(int schedulerId) throws SchedulerNotFoundExcption {
		Optional<Scheduler> scheduler = repository.findById(schedulerId);
		if (!scheduler.isPresent())
			throw new SchedulerNotFoundExcption();

		repository.deleteById(schedulerId);
		
	}

	@Override
	public Scheduler addScheduler(Scheduler scheduler) {
		logger.info("inside addScheduler method of SchedulerServiceImpl");
		return repository.save(scheduler);
	}

	@Override
	public List<Scheduler> fetchAll() {
		return repository.findAll();
		
	}

	
	

}

/*
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
}*/