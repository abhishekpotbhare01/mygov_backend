package com.egov.dto;

import com.egov.entity.FarmerScheme;
import com.egov.entity.SchemeMaster;
import com.egov.entity.StudentScheme;
import com.egov.entity.WomenScheme;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordDto {
	private String email;
    private String password;
}
