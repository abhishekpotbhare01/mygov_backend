package com.egov.dto;

import com.egov.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private int studentSchemeId;
    private Student studentDetails;
    private double familyIncome;
    private SchemeMaster schemeMaster;
    private Address address;
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
}