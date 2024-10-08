package com.egov.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer beneficiaryId;
    private String name;
    private Integer addressId;
    private Integer age;
    private String mobile;

    public Beneficiary(String name, Integer addressId, Integer age, String contact) {

        this.name = name;
        this.addressId = addressId;
        this.age = age;
        this.mobile = contact;
    }

    public Beneficiary() {

    }

    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getName() {
        return name;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Integer getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setBeneficiaryId(Integer beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMobile(String contact) {
        this.mobile = contact;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "beneficiaryId=" + beneficiaryId +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", age=" + age +
                ", contact='" + mobile + '\'' +
                '}';
    }
}
