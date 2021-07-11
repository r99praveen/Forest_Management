package com.cg.fms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Order_tbl")             
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "cart_item")       
	@NotNull
	private String cartItem;
	
	@Column(name = "quantity")       
	@NotNull
	private int quantity;
	
	@Column(name = "totalPrice")
	@NotNull
	private int totalPrice;
	
	@Column(name = "name")       
	@NotNull
	private String name;
	
	@Column(name = "Email")       
	@NotNull
	private String email;
	
	@Column(name = "address")
	@NotNull
	private String address;
	
	@Column(name = "Contact")
	@NotNull
	private int contact;
	

	@Column(name = "postalCode")
	@NotNull
	private int postalCode;
	
	@Column(name = "Town")
	@NotNull
	private String town;
	

//	@Column(name = "truckNumber")
//	@NotNull
//	private String truckNumber;
	
	
	
	
	
	
//	
//	@Column(name = "quantity")
//	@NotNull
//	private int quantity;
	
	
	
//	@OneToMany(targetEntity = Contract.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "occ_fk", referencedColumnName = "id")
//	private List<Contract> contracts;
//	

}