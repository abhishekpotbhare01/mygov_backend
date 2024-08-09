package com.egov.dto;

import com.egov.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer userId;
	private int age;
	private String email;
	private String password;
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = Access.READ_ONLY)
	private Role role = Role.USER;

	public UserDto(int age, String email, String password, String confirmPassword, Role role) {
		this.age = age;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}
}
