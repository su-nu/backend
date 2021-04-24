package com.example.backend.entity;


import com.example.backend.appUser.AppUser;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "BILLING_ADRESS")
public class BillingAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String streetNr;
    private String addition;
    private String plz;
    private String locus;
    private String country;

    @OneToOne(mappedBy = "billingAdress")
    private AppUser appUser;
}
