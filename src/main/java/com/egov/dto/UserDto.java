package com.egov.dto;

import com.egov.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer userId;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    @Enumerated(EnumType.STRING)
    private Role role;


    public UserDto(int age, String email, String password, String confirmPassword, Role role) {
        this.age = age;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }
}