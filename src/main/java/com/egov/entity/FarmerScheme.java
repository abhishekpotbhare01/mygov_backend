package com.egov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "farmer_scheme")

public class FarmerScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerSchemeId;
    private String landDetails;
    private double income;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheme_id", unique = false)
    private SchemeMaster schemeMaster;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", unique = false)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = false)
    private User userId;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
}