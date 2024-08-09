package com.egov.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "disability_scheme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisabilityScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer disabilitySchemeId;
	
	@Enumerated(EnumType.STRING)
	private DisabilityType disabilityType;
	
	private String certificate;
	private String certifyingAuthority;
	
	@OneToOne
	@JoinColumn(name = "emergency_contact")
	private Emergency emergencyContact;	
}
