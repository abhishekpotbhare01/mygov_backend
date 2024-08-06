package com.egov.dto;

import com.egov.entity.AgeCatagory;
import com.egov.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchemeDto {
    private Integer schemeId;
    private String name;
    private String schemeDescription;
    private Date launchDate;
    private AgeCatagory age;
    private Category category;
    private String eligibilityCriteria;
    private String docRequired;
}