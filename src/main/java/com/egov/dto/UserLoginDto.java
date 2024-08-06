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
public class UserLoginDto {
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}