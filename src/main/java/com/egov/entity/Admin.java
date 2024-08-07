package com.egov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String name;
    private Designation designation;
    private Integer addressId;
    private Integer age;
    private String contact;

    public Admin(String name, Designation designation, Integer addressId, Integer age, String contact) {
        this.name = name;
        this.designation = designation;
        this.addressId = addressId;
        this.age = age;
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




