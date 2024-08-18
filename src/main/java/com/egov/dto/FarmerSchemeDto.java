package com.egov.dto;

import com.egov.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

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
    private Integer landArea;
    private SchemeMaster schemeMaster;
    private Address address;
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    private String comments;
    private LocalDate applicationDate;
    private BankDetails bankDetails;
}