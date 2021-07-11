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
@Table(name = "Contract_tbl")             
public class Contract {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name = "customer_name")       
	@NotNull
	private String customer_name;
	
	@Column(name = "product_name")       
	@NotNull
	private String product_name;
	
	@Column(name = "quantity")       
	@NotNull
	private String quantity;
	
	
	@Column(name = "duration")
	@NotNull
	private String duration;
	
	@Column(name = "value")
	@NotNull
	private String value;
	
	@Column(name = "customer_number")       
	@NotNull
	private String customer_number;
	
	
	@Column(name = "customer_location")       
	@NotNull
	private String customer_location;
	
	
}