package com.example.backend.entity;


import com.example.backend.appUser.AppUser;
import com.example.backend.request.BillingAdressRequest;
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

    public BillingAdress(String street,
                         String streetNr,
                         String addition,
                         String plz,
                         String locus,
                         String country) {
        this.street = street;
        this.streetNr = streetNr;
        this.addition = addition;
        this.plz = plz;
        this.locus = locus;
        this.country = country;

    }
}
