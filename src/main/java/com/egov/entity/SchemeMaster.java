package com.egov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "scheme_master")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class SchemeMaster {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schemeId;
    private String schemeName;
    private String schemeDescription;
    private LocalDate launchDate;
    @Enumerated(EnumType.STRING)
    private AgeCatagory age;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String eligibilityCriteria;
    @Column(name = "document")
    private String docRequired;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "form_path")
    private String formPath;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SchemeConst schemeConst;


    public SchemeMaster(Integer schemeId, String schemeName, String schemeDescription, LocalDate launchDate,
                        AgeCatagory age, Category category, String eligibilityCriteria, String docRequired, String imageUrl,
                        String formPath) {
        this.schemeId = schemeId;
        this.schemeName = schemeName;
        this.schemeDescription = schemeDescription;
        this.launchDate = launchDate;
        this.age = age;
        this.category = category;
        this.eligibilityCriteria = eligibilityCriteria;
        this.docRequired = docRequired;
        this.imageUrl = imageUrl;
        this.formPath = formPath;
    }


    @Override
    public String toString() {
        return "Scheme{" + "schemeId=" + schemeId + ", SchemeName='" + schemeName + '\'' + ", schemeDescription='" + schemeDescription + '\'' + ", launchDate=" + launchDate + ", age=" + age + '}';
    }

}