package com.egov.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Integer addressId;
    private String village_street;
    private String city;
    private String state;
    private String zip;
    private String country;
}