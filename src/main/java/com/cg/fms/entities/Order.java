package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                                      
@NoArgsConstructor                        
@Entity                                   
@Table(name = "Order_tbl")             
public class Order {
	
	@Id                                
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ordernumber;
	
	@Column(name = "deliveryplace")       
	@NotNull
	private String deliveryplace;
	
	@Column(name = "deliverydate")
	@NotNull
	private String deliverydate;
	
	@Column(name = "quantity")
	@NotNull
	private String quantity;
	
	
}