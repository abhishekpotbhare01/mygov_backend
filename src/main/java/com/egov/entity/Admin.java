package com.egov.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @Column(unique=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer adminId;
    private String name;
    private Designation designation;
    private Integer addressId;
    private Integer age;
    private String contact;


    public Admin( String name, Designation designation, Integer addressId, Integer age, String contact) {
        this.name = name;
        this.designation = designation;
        this.addressId = addressId;
        this.age = age;
        this.contact = contact;
    }

    public Admin() {

    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Integer getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", designation=" + designation +
                ", addressId=" + addressId +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                '}';
    }
}




