package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Contract;


@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

}