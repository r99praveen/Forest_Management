package com.cg.fms.controller;
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
import com.cg.fms.services.IAdminService;
import io.swagger.annotations.ApiOperation;
import com.cg.fms.exception.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/register-admin")
public class AdminController {
		
	@Autowired
	private IAdminService adminService;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@PostMapping("register-admin")
	public ResponseEntity<Admin> registerUserAccount(@Valid @RequestBody Admin admin) throws AdminEmailAlreadyExistExeption, AdminNameExeption, ConfirmPasswordException
	{
//		bCryptPasswordEncoder.encode(user.getPassword());
				
		Admin admin1 = adminService.save(admin);
		
		return new ResponseEntity<Admin>(admin1,HttpStatus.CREATED);
	}	
	

	
	@PostMapping("login")
	public ResponseEntity<Login>  login(@RequestBody  Login login,HttpSession session) throws InvalidEmailAndPassword
	{
		String email= login.getEmail();
		String pwd = login.getPassword();
		
		
		if(adminService.findByEmailAndPassword(email, pwd)==false) 
		{
			throw new InvalidEmailAndPassword();
		}
		
		
		
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("admin/{email}")
	public Admin getAdminDetails(@PathVariable String email) throws AdminDoesNotExist{
		Admin admin=adminService.getByEmail(email);
		return admin;
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) throws AdminDoesNotExist{
		
		adminService.deleteAdmin(Long.valueOf(id));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	

	
	
	@PutMapping("/update")
	@ApiOperation("update customer details ")
	public Admin update(@Valid @RequestBody Admin admin) {
		
		return adminService.updateAdmin(admin);
		
	}

	
}