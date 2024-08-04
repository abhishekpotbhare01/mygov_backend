package com.egov.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer userId;
    private String email;
    private String password;

    public User(Integer userId, Integer userId1, String email, String password) {
        this.userId = userId;
        this.userId = userId1;
        this.email = email;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
