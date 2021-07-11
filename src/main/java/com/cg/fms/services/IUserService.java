package com.cg.fms.services;



import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.User;
import com.cg.fms.exception.ConfirmPasswordException;
import com.cg.fms.exception.InvalidEmailAndPassword;
import com.cg.fms.exception.UserDoesNotExist;
import com.cg.fms.exception.UserEmailAlreadyExistException;
import com.cg.fms.exception.UserNameException;

@Service
public interface IUserService {
	// for registration
	public User save(User user)throws UserEmailAlreadyExistException, UserNameException, ConfirmPasswordException;
	
	// for login
	public boolean findByEmailAndPassword(String email,String password) throws InvalidEmailAndPassword;

	// for deleting
	public void deleteUser(Long valueOf) throws UserDoesNotExist;

	// for updating
	public User updateUser(@Valid User user);

//	User getByEmail(String email) throws UserDoesNotExist;
	// by default ABSTRACT methods are public 
	
	// List<User> fetchAll();
	public User getByEmail(String email) throws UserDoesNotExist;
	 

}