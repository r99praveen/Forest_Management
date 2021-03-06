package com.cg.fms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Schdl_tbl")
public class Scheduler{

	
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
	
	
	@Column(name = "truckNumber")
	@NotNull
	private int truckNumber;
	
	
}