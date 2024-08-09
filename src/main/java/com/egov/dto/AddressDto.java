package com.egov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
	@JsonProperty(access = Access.READ_ONLY)
    private Integer addressId;
    private String village_street;
    private String city;
    private String state;
    private String zip;
    private String country;
}