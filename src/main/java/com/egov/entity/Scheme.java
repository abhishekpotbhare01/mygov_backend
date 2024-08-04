package com.egov.entity;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="scheme")
public class Scheme {
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    private Integer schemeId;
    private String name;
    private String schemeDescription;
    private Date launchDate;
    private AgeCatagory age;

    public Scheme( String name, String schemeDescription, Date launchDate, AgeCatagory age) {

        this.name = name;
        this.schemeDescription = schemeDescription;
        this.launchDate = launchDate;
        this.age = age;
    }

    public Scheme() {

    }


    public Integer getSchemeId() {
        return schemeId;
    }

    public String getName() {
        return name;
    }

    public String getSchemeDescription() {
        return schemeDescription;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public AgeCatagory getAge() {
        return age;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchemeDescription(String schemeDescription) {
        this.schemeDescription = schemeDescription;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public void setAge(AgeCatagory age) {
        this.age = age;
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

