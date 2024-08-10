package com.egov.dto;

import com.egov.entity.AgeCatagory;
import com.egov.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchemeMasterDto {
	@JsonProperty(access = Access.READ_ONLY)
    private Integer schemeId;
    private String schemeName;
    private String schemeDescription;
    private LocalDate launchDate;
    @Enumerated(EnumType.STRING)
    private AgeCatagory age;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String eligibilityCriteria;
    private String docRequired;
}