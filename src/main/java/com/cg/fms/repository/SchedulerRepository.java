package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Scheduler;

import java.util.List;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {

	public List<Scheduler> getAllSchedulers();

	


	
}