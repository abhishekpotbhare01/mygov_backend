package com.egov.dto;

import com.egov.entity.AgeCatagory;
import com.egov.entity.Category;
import com.egov.entity.SchemeConst;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

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
    private String imageUrl;
    private String formPath;
    @Enumerated(EnumType.STRING)
    private SchemeConst schemeConst;
    @JsonProperty(access = Access.READ_ONLY)
    private int approvalCount = 0;
    @JsonProperty(access = Access.READ_ONLY)
    private int pendingCount = 0;
}