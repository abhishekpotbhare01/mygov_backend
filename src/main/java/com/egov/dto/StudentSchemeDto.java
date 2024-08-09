package com.egov.dto;

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
    private SchemeMaster schemeMaster;
    private Address address;
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
}