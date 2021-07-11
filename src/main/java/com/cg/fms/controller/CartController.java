package com.cg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


import com.cg.fms.entities.Cart;
import com.cg.fms.exception.CartItemNotFoundException;
import com.cg.fms.services.ICartService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class CartController {

	Logger logger = LoggerFactory.getLogger(CartController.class);
@Autowired
	private ICartService service;

	

	@GetMapping("/getById/{id}")
	@ApiOperation("Get Cart_item By ID")
	public Cart fetchById(@PathVariable int id) throws NumberFormatException ,CartItemNotFoundException{
		logger.info("Inside fetchById %s", id);
		return service.fetchById(id);
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all Cart_item Details")
	public List<Cart> fetch() {
		logger.info("Fetching all Cart_item records!!");
		return service.fetchAll();
	}

	@PostMapping("/save")
	@ApiOperation("Add a Cart_item")
	public ResponseEntity<Cart> save(@Valid @RequestBody Cart cart) {
		logger.info("Adding a cart_items : " + cart);
		Cart  car= service.addCart(cart);
		return new ResponseEntity<>(car, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	@ApiOperation("Update an Existing  cart_item ")
	public void update(@Valid @RequestBody Cart cart) {
		logger.info("Updating a cart!!");
		service.updateCart(cart);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete an Existing cart_item Record")
	public ResponseEntity<Void> delete(@PathVariable int id) throws CartItemNotFoundException {
		logger.info("Deleting a cart_item!!");
		service.delCart(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	

}