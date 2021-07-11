package com.cg.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByAdminName(String adminName);

	//Optional<User> findByEmail(String email);
	
	Admin findByEmail(String email);
	
	Optional<Admin> findByEmailAndPassword(String email , String password);
}