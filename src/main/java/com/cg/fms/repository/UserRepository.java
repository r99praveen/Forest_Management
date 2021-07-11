package com.cg.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.fms.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	//Optional<User> findByEmail(String email);
	
	User findByEmail(String email);
	
	Optional<User> findByEmailAndPassword(String email , String password);
}