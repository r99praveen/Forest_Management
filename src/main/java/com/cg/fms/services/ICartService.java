package com.cg.fms.services;

import com.cg.fms.exception.CartItemNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Cart;

@Service
public interface ICartService {

	
	
	Cart fetchById(int id) throws CartItemNotFoundException;
	
	
	Cart addCart(Cart cart);
	
	
	void  updateCart(Cart cart);
	
	
	void delCart(int id) throws CartItemNotFoundException;
	
	
	List<Cart> fetchAll();
}