package com.cg.fms.services;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.entities.User;
import com.cg.fms.exception.ConfirmPasswordException;
import com.cg.fms.exception.InvalidEmailAndPassword;
import com.cg.fms.exception.UserDoesNotExist;
import com.cg.fms.exception.UserEmailAlreadyExistException;
import com.cg.fms.exception.UserNameException;
import com.cg.fms.repository.UserRepository;


@Service
public  class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder
	
	@Override
	public User save( User user ) throws UserEmailAlreadyExistException, UserNameException, ConfirmPasswordException 
	{
	
	//	user.setPassword(passwordEncoder.encode(user.getPassword()));
	if(checkIfEmailExist(user.getEmail()))
	{
		throw new UserEmailAlreadyExistException();
	}
	if(checkIfUserNameExist(user.getUserName())) 
	{
		throw new UserNameException();
		
	}
	if(!(user.getPassword().equals(user.getConfirmPassword())))
	{
	//	user.getPassword().equals(user.getConfirmPassword())
		throw new ConfirmPasswordException();
	}
	

	user.setRoll("Trainee");
		
		return	userRepository.save(user);
	}
	
	//check with mail
	public boolean checkIfEmailExist(String email) {// this is for registration 
		return userRepository.findByEmail(email) != null ? true : false;
	}

	// check with username
	public boolean checkIfUserNameExist(String userName) {//this is for registration
		return userRepository.findByUserName(userName) != null ? true : false;
	}
	

	//for Login
	@Override
	public boolean findByEmailAndPassword(String email, String password) throws InvalidEmailAndPassword {
		Optional<User> user =userRepository.findByEmailAndPassword(email, password);
		if(!user.isPresent()){
			throw new InvalidEmailAndPassword();
		}
		
		return userRepository.findByEmailAndPassword(email, password) != null ? true:false;
	}



	@Override
	public User getByEmail(String email) throws UserDoesNotExist  {
		
		Optional<User> user=Optional.ofNullable(userRepository.findByEmail(email));
		if(!user.isPresent()) 
		{
			throw new UserDoesNotExist(); 
		}
		
		return user.get();
	}
	

	@Override
	public void deleteUser(Long id) throws UserDoesNotExist {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
		{
			throw new UserDoesNotExist();
		}
		userRepository.deleteById(id);
		
	}

	
	

	@Override
	public User updateUser(@Valid User user) {
		
		return userRepository.save(user);
	}
}