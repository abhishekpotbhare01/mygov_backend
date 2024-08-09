package com.egov.dto;

import com.egov.entity.Address;
import com.egov.entity.SchemeMaster;
import com.egov.entity.Status;
import com.egov.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmerSchemeDto {
	@JsonProperty(access = Access.READ_ONLY)
    private Integer farmerSchemeId;
    private String landDetails;
    private double income;
    private SchemeMaster schemeMaster;
    private Address address;
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
}