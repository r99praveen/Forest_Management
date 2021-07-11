package com.cg.fms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "adminScheduler_table")
public class AdminScheduler {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 4 , message  = "shoud have mini 4 chars !")
//	@Column(name = "userName" , unique = true , nullable = false)
	private String adminName;
		
	@NotNull
	@Size(min = 4, message = "firstName shoud have mini 4 chars !")
	private String firstName;
	
	
	@NotNull
	@Size(min = 4, message = "secondName shoud have mini 4 chars !")
	private String lastName;
	
//	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private String gender;
	
	
	@Column(name = "address")
	private String address;
	
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message = "emial should not matched pattern !!")
	private String email;
		
	
	@NotNull
//	@Size(min = 8 ,message = " password should have minimum 8 characters ")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" ,message = "password should contain minimun 8 characters :")
	private String password;
	
	private String confirmPassword;
		

	@Column(name = "roll")
    private String roll;
}