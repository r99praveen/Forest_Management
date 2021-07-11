package com.cg.fms.dto;

import com.cg.fms.entities.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;

//Its not entity class, so don't write @Entity annotation
@Data
@NoArgsConstructor
public class OrderRequest {
	private Customer customer;
}
