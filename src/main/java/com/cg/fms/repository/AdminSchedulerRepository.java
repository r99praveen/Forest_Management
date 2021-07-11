package com.cg.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.AdminScheduler;


public interface AdminSchedulerRepository extends JpaRepository<AdminScheduler, Long> {

	AdminScheduler findByAdminName(String adminSchedulerName);

	//Optional<User> findByEmail(String email);
	
	AdminScheduler findByEmail(String email);
	
	Optional<AdminScheduler> findByEmailAndPassword(String email , String password);
}