package com.egov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "student_scheme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentSchemeId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student studentDetails;
    private double familyIncome;
    @CreationTimestamp
    private LocalDate applicationDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheme_id")
    private SchemeMaster schemeMaster;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
}