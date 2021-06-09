package com.cg.fms.services;

import java.util.List;

import com.cg.fms.entities.Scheduler;
import com.cg.fms.exception.InvalidSchedulerException;
import com.cg.fms.exception.SchedulerNotFoundExcption;

public interface ISchedulerservice {
	
	 Scheduler fetchById(int schedulerId) throws SchedulerNotFoundExcption;

	 void updateScheduler(Scheduler scheduler);

	 void delScheduler(int schedulerId) throws  SchedulerNotFoundExcption;

	  Scheduler addScheduler(Scheduler scheduler);
	
	 List<Scheduler> fetchAll();
}

/*package com.cg.fms.services;


import com.cg.fms.exception.ContractNotFoundException;
import com.cg.fms.entities.Contract;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface IContractService {

	
	
	Contract fetchById(int contractnumber) throws ContractNotFoundException;
	
	
	Contract addContract(Contract contract);
	
	
	void  updateContract(Contract contract);
	
	
	void delContract(int contractnumber) throws ContractNotFoundException;
	
	
	List<Contract> fetchAll();
}*/
