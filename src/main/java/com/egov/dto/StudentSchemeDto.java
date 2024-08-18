package com.egov.dto;

import java.time.LocalDate;

import com.egov.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StudentSchemeDto {
	@JsonProperty(access = Access.READ_ONLY)
    private int studentSchemeId;
    private Student studentDetails;
    private double familyIncome;
	@JsonProperty(access = Access.READ_ONLY)
    private SchemeMasterDto schemeMaster;
    private AddressDto address;
	@JsonProperty(access = Access.READ_ONLY)
    private UserDto user;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDate applicationDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    private String comments;
}