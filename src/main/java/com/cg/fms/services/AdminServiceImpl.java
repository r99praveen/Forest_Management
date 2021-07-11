package com.cg.fms.services;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.entities.Admin;
import com.cg.fms.repository.AdminRepository;
import com.cg.fms.exception.*;


@Service
public  class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder
	
	@Override
	public Admin save( Admin admin ) throws AdminEmailAlreadyExistExeption, AdminNameExeption, ConfirmPasswordException 
	{
	
	//	user.setPassword(passwordEncoder.encode(user.getPassword()));
	if(checkIfEmailExist(admin.getEmail()))
	{
		throw new AdminEmailAlreadyExistExeption();
	}
	if(checkIfUserNameExist(admin.getAdminName())) 
	{
		throw new AdminNameExeption();
		
	}
	if(!(admin.getPassword().equals(admin.getConfirmPassword())))
	{
	//	user.getPassword().equals(user.getConfirmPassword())
		throw new ConfirmPasswordException();
	}
	

	admin.setRoll("Trainee");
		
		return	adminRepository.save(admin);
	}
	
	//check with mail
	public boolean checkIfEmailExist(String email) {// this is for registration 
		return adminRepository.findByEmail(email) != null ? true : false;
	}

	// check with username
	public boolean checkIfUserNameExist(String adminName) {//this is for registration
		return adminRepository.findByAdminName(adminName) != null ? true : false;
	}
	

	//for Login
	@Override
	public boolean findByEmailAndPassword(String email, String password) throws InvalidEmailAndPassword {
		Optional<Admin> admin =adminRepository.findByEmailAndPassword(email, password);
		if(!admin.isPresent()){
			throw new InvalidEmailAndPassword();
		}
		
		return adminRepository.findByEmailAndPassword(email, password) != null ? true:false;
	}



	@Override
	public Admin getByEmail(String email) throws AdminDoesNotExist  {
		
		Optional<Admin> admin=Optional.ofNullable(adminRepository.findByEmail(email));
		if(!admin.isPresent()) 
		{
			throw new AdminDoesNotExist(); 
		}
		
		return admin.get();
	}
	

	@Override
	public void deleteAdmin(Long id) throws AdminDoesNotExist {
		Optional<Admin> admin = adminRepository.findById(id);
		if(!admin.isPresent())
		{
			throw new AdminDoesNotExist();
		}
		adminRepository.deleteById(id);
		
	}

	
	

	@Override
	public Admin updateAdmin(@Valid Admin admin) {
		
		return adminRepository.save(admin);
	}
}