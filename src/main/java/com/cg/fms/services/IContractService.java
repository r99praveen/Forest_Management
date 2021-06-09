package com.cg.fms.services;

import java.util.List;

import com.cg.fms.entities.Contract;
import com.cg.fms.exception.InvalidContractException;

public interface IContractService {
	
	public Contract getContract(int contractNumber) throws InvalidContractException;
	public Contract addContract(Contract contract);
	public Contract updateContract(Contract contract);
	public void delContract(int contractNumber) throws  InvalidContractException;
	public List<Contract> getAllContracts();
	
}
