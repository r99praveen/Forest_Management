package com.cg.fms.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.fms.entities.Product;
import com.cg.fms.exception.ProductNotFoundExcption;
import com.cg.fms.services.IProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductService service; 
	
	
	
	@GetMapping("/getById/{id}")                //GETTING PRODUCT BY ID
	@ApiOperation("Get Product By ID")
	public Product fetchById(@PathVariable int id) throws NumberFormatException, ProductNotFoundExcption {
		logger.info("Inside fetchById %s", id);
		return service.fetchById(id);
	}
		
	
		
		
	@PostMapping("/save")                        //ADDING A NEW PRODUCT
	@ApiOperation("Add a new product")
	public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
		logger.info("Adding a product : " + product);
		Product prod = service.addProduct(product);
		return new ResponseEntity<>(prod, HttpStatus.CREATED);
	}
	

	
	
	
	@PutMapping("/update")                        //UPDATE EXISTING PRODUCT 
	@ApiOperation("Update an Existing Product")
	public void update(@Valid @RequestBody Product product) {
		logger.info("Updating a product!!");
		service.updateProduct(product);
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")               //DELETING AN EXISTING PRODUCT WITH ID
	@ApiOperation("Delete an Existing Product")
	public ResponseEntity<Void> delete(@PathVariable int id) throws ProductNotFoundExcption,NumberFormatException{
		logger.info("Deleting a product!!");
		service.delProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	@GetMapping("/getAll")                      // LIST ALL PRODUCTS
	@ApiOperation("Fetch all Product Details")
	public List<Product> fetch() {
	logger.info("Fetching all Products!");
	return service.fetchAll();
	}
	
}

	