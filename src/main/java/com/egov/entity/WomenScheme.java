package com.egov.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.egov.entity.MaritialStatus;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
    //private LocalDate DOB;
    private Long phoneNumber;
    @Enumerated(EnumType.STRING)
    private com.egov.entity.MaritialStatus maritialStatus;
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
    @CreationTimestamp
    private LocalDate applicationDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

}
