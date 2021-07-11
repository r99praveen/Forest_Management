package com.cg.fms.services;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fms.entities.Admin;
import com.cg.fms.entities.AdminScheduler;
import com.cg.fms.repository.AdminRepository;
import com.cg.fms.repository.AdminSchedulerRepository;
import com.cg.fms.services.IAdminScheduler;
import com.cg.fms.exception.*;


@Service
public  class AdminSchedulerServiceImpl implements IAdminScheduler{
	
	@Autowired
	private AdminSchedulerRepository adminSchedulerRepository;

	@Override
	public AdminScheduler save(AdminScheduler adminScheduler) throws AdminSchedulerEmailAlreadyExistException,AdminSchedulerNameException,
			 ConfirmPasswordException {
		
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(checkIfEmailExist(adminScheduler.getEmail()))
		{
			throw new AdminSchedulerEmailAlreadyExistException();
		}
		if(checkIfUserNameExist(adminScheduler.getAdminName())) 
		{
			throw new AdminSchedulerNameException();
			
		}
		if(!(adminScheduler.getPassword().equals(adminScheduler.getConfirmPassword())))
		{
		//	user.getPassword().equals(user.getConfirmPassword())
			throw new ConfirmPasswordException();
		}
		

		adminScheduler.setRoll("Trainee");
			
			return	adminSchedulerRepository.save(adminScheduler);
		}
		
	
	private boolean checkIfUserNameExist(String email) {
		return adminSchedulerRepository.findByEmail(email) != null ? true : false;
	}


	private boolean checkIfEmailExist(String adminSchedulerName) {
		return adminSchedulerRepository.findByAdminName(adminSchedulerName) != null ? true : false;
	}


	

	@Override
	public boolean findByEmailAndPassword(String email, String password) throws InvalidEmailAndPassword {
		Optional<AdminScheduler> adminScheduler =adminSchedulerRepository.findByEmailAndPassword(email, password);
		if(!adminScheduler.isPresent()){
			throw new InvalidEmailAndPassword();
		}
		
		return adminSchedulerRepository.findByEmailAndPassword(email, password) != null ? true:false;
	}

	@Override
	public void deleteAdmin(Long id) throws AdminSchedulerDoesNotExist {
		Optional<AdminScheduler> adminScheduler = adminSchedulerRepository.findById(id);
		if(!adminScheduler.isPresent())
		{
			throw new AdminSchedulerDoesNotExist();
		}
		adminSchedulerRepository.deleteById(id);
		
		
	}

	@Override
	public AdminScheduler updateAdmin(@Valid AdminScheduler adminscheduler) {
		return adminSchedulerRepository.save(adminscheduler);
	}

	@Override
	public AdminScheduler getByEmail(String email) throws AdminSchedulerDoesNotExist {

		Optional<AdminScheduler> admin=Optional.ofNullable(adminSchedulerRepository.findByEmail(email));
		if(!admin.isPresent()) 
		{
			throw new AdminSchedulerDoesNotExist(); 
		}
		
		return admin.get();
	}
	
}