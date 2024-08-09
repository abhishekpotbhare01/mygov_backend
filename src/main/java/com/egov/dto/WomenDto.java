package com.egov.dto;

import java.time.LocalDate;

import com.egov.entity.MaritialStatus;
import com.egov.entity.SchemeMaster;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WomenDto {

private Integer id;
private String Name;
private int age;
private LocalDate DOB;
private Long phoneNumber;
private String Occupation;
private MaritialStatus status;
private long annualIncome;
private SchemeMaster sctScheme;
}
