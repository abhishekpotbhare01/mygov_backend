package com.egov.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="women")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Women {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String Name;
private int age;
private LocalDate DOB;
private Long phoneNumber;
private String Occupation;
private MaritialStatus maritialStatus;
private long annualIncome;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "scheme_id")
private SchemeMaster schemeMaster;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "address_id")
private Address address;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_id")
private User userId;
@Enumerated(EnumType.STRING)
private Status status = Status.PENDING;



}
