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
@Table(name = "Product_tbl")      
    public class Product {
	
	@Id                               
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")       
	@NotNull
	@Size(min = 3, message = "Product Name should have mininum 3 characters!!")
	private String name;
	
	@Column(name = "description")
	@NotNull
	@Size(min = 15, message = "Product Description should have mininum 15 characters!!")
	private String description;
	
	@Column(name = "price")
	@NotNull
	private String price;
	
	@Column(name = "quantity")
	@NotNull
	private String quantity;
	
		
}