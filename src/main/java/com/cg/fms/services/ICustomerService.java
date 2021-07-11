package com.cg.fms.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.fms.entities.Customer;
import com.cg.fms.exception.CustomerNotFoundException;

@Service
public interface ICustomerService {

	Customer addCustomer(Customer customer);

	List<Customer> fetchAll();

	void delCustomer(int id) throws CustomerNotFoundException;

	void updateCustomer(Customer customer);

	Customer fetchById(int id) throws CustomerNotFoundException;

	/*Customer getByLastName(String lastName);*/

	/*Customer getByFirstName(String firstName);*/

	

}