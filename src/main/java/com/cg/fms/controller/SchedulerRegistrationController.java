package com.cg.fms.controller;
import java.lang.NumberFormatException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fms.entities.Login;
import com.cg.fms.entities.Admin;
import com.cg.fms.entities.AdminScheduler;
import com.cg.fms.services.IAdminScheduler;
import io.swagger.annotations.ApiOperation;
import com.cg.fms.exception.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/register-adminScheduler")
public class SchedulerRegistrationController {
		
	@Autowired
	private IAdminScheduler adminSchedulerService;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@PostMapping("register-scheduler")
	public ResponseEntity<AdminScheduler> registerUserAccount(@Valid @RequestBody AdminScheduler admin) throws AdminSchedulerEmailAlreadyExistException, AdminSchedulerNameException, ConfirmPasswordException, AdminSchedulerNameDoesNotExistExeption
	{
//		bCryptPasswordEncoder.encode(user.getPassword());
				
		AdminScheduler admin1 = adminSchedulerService.save(admin);
		
		return new ResponseEntity<AdminScheduler>(admin1,HttpStatus.CREATED);
	}	
	

	
	@PostMapping("login")
	public ResponseEntity<Login>  login(@RequestBody  Login login,HttpSession session) throws InvalidEmailAndPassword
	{
		String email= login.getEmail();
		String pwd = login.getPassword();
		
		
		if(adminSchedulerService.findByEmailAndPassword(email, pwd)==false) 
		{
			throw new InvalidEmailAndPassword();
		}
		
		
		
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("admin/{email}")
	public AdminScheduler getAdminDetails(@PathVariable String email) throws AdminSchedulerDoesNotExist{
		AdminScheduler admin=adminSchedulerService.getByEmail(email);
		return admin;
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) throws  NumberFormatException, AdminSchedulerDoesNotExist{
		
		adminSchedulerService.deleteAdmin(Long.valueOf(id));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	

	
	
	@PutMapping("/update")
	@ApiOperation("update customer details ")
	public AdminScheduler update(@Valid @RequestBody AdminScheduler admin) {
		
		return adminSchedulerService.updateAdmin(admin);
		
	}

	
}