package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}