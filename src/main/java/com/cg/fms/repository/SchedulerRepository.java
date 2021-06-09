package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Scheduler;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Integer> {


	


	
}