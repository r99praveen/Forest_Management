package com.cg.fms.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Table(name = "contract_tbl")
public class Contract{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contractNumber;
	
	@Column(name = "deliverplace")
	@NotNull
	private String deliveryPlace;
	
	@Column(name = "deliverdate")
	@NotNull
	private String deliveryDate;
	
	@Column(name = "quantity")
	@NotNull
	private String quantity;
	
}
