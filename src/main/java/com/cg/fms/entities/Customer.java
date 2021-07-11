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
@Table(name = "Customer_tbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name = "name")
	@NotNull
	@Size(min = 2, message = "Name should have mininum 2 characters!!")
	private String name;
	

	@Column(name = "email")
	@Email(message = "Enter a valid email address!!")
	private String email;
	
	
	@Column(name = "address")
	@NotNull
	private String address;
	
	
	@Column(name = "town")
	private String town;
	
	
	@Column(name = "postal_code")
	@NotNull
	private long postalcode;
	
	
	@Column(name = "contact")
	private long contact;


	
//	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "co_fk", referencedColumnName = "id")
//	private List<Order> orders;
	
	



}