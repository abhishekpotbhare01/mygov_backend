package com.egov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "women_scheme")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WomenScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private Long phoneNumber;
    private MaritialStatus maritialStatus;
    private long annualIncome;
    @ManyToOne(cascade = CascadeType.ALL)
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
