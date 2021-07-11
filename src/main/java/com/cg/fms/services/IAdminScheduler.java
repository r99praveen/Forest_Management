package com.cg.fms.services;



import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.AdminScheduler;
import com.cg.fms.exception.*;

@Service
public interface IAdminScheduler {
	// for registration
	public AdminScheduler save(AdminScheduler adminScheduler)throws AdminSchedulerEmailAlreadyExistException,AdminSchedulerNameException, ConfirmPasswordException;
	
	// for login
	public boolean findByEmailAndPassword(String email,String password) throws InvalidEmailAndPassword;

	// for deleting
	public void deleteAdmin(Long valueOf) throws AdminSchedulerDoesNotExist;

	// for updating
	public AdminScheduler updateAdmin(@Valid AdminScheduler adminscheduler);

//	User getByEmail(String email) throws UserDoesNotExist;
	// by default ABSTRACT methods are public 
	
	// List<User> fetchAll();
	public AdminScheduler getByEmail(String email) throws AdminSchedulerDoesNotExist;
	 

}