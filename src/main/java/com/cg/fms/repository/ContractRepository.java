package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Contract;
import com.cg.fms.exception.InvalidContractException;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
	
	public Contract getContract(int contractNumber);
	public Contract addContract(int contractNumber);
	public Contract updateContract(Contract contract);
	public Contract deleteByContract(int contractNumber) throws  InvalidContractException;
	public List<Contract> getAllContracts();
	
}