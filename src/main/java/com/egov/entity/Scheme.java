package com.egov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "scheme")

@Getter
@Setter
@NoArgsConstructor
public class Scheme {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schemeId;
    private String name;
    private String schemeDescription;
    private LocalDate launchDate;
    private AgeCatagory age;
    private Category category;
    private String eligibilityCriteria;

    @Column(name = "document")
    private String docRequired;


    public Scheme(String name, String schemeDescription, LocalDate launchDate,
                  AgeCatagory age, Category category, String eligibilityCriteria, String docRequired) {
        this.name = name;
        this.schemeDescription = schemeDescription;
        this.launchDate = launchDate;
        this.age = age;
        this.category = category;
        this.eligibilityCriteria = eligibilityCriteria;
        this.docRequired = docRequired;
    }

    @Override
    public String toString() {
        return "Scheme{" +
                "schemeId=" + schemeId +
                ", name='" + name + '\'' +
                ", schemeDescription='" + schemeDescription + '\'' +
                ", launchDate=" + launchDate +
                ", age=" + age +
                '}';
    }
}

