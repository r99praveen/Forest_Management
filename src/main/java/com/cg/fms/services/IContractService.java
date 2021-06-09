package com.cg.fms.services;


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
}
