package com.egov.dto;

import java.time.LocalDate;

import com.egov.entity.Address;
import com.egov.entity.MaritialStatus;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import com.egov.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WomenSchemeDto {

	private String firstName;
    private String lastName;
    private LocalDate DOB;
    private Long phoneNumber;
    private MaritialStatus maritialStatus;
    private long annualIncome;
    private SchemeMaster schemeMaster;
    private Address address;
    private User userId;
    private Status status = Status.PENDING;
}
