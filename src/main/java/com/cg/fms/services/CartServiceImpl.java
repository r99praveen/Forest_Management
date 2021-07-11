package com.cg.fms.services;


import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.fms.exception.CartItemNotFoundException;
import com.cg.fms.entities.Cart;

import com.cg.fms.repository.CartRepository;
import com.cg.fms.services.CartServiceImpl;

import org.slf4j.LoggerFactory;

@Service
public  class CartServiceImpl implements ICartService{
	
	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CartRepository repository;

	
	
	
	@Override
	public Cart fetchById(int id) throws CartItemNotFoundException {
		Optional<Cart> cart = repository.findById(id);
		if (!cart.isPresent())
			throw new CartItemNotFoundException();
		return cart.get();
	}
	
	
	
	
	@Override
	public Cart addCart(Cart cart) {
		logger.info("inside addProduct method of ProductServiceImpl");
		return repository.save(cart);
	}
	
	// updating a product //
	
	@Override
	public void updateCart(Cart cart) {
		repository.save(cart);
	}
	
	
	// deleting a product
	
	@Override
	public void delCart(int id) throws CartItemNotFoundException {
		Optional<Cart> product = repository.findById(id);
		if (!product.isPresent())
			throw new CartItemNotFoundException();

		repository.deleteById(id);
	}
		
	
	
	// get all product
	@Override
	public List<Cart> fetchAll() {
		return repository.findAll();
	}
}