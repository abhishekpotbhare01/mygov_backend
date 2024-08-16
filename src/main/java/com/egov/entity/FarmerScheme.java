package com.egov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;


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
    private String comments;
    @CreatedDate
    private LocalDate applicationDate;
}