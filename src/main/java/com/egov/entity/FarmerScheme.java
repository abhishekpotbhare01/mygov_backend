package com.egov.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FarmerScheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerSchemeId;
    private String landDetails;
    private double income;
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