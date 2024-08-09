package com.egov.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emergency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emergency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emergencyContactId;
	
	private String name;
	private String relation;
	private String phone;
	
	
}
