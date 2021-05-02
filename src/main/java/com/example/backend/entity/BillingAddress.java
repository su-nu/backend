package com.example.backend.entity;


import com.example.backend.appUser.AppUser;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "BILLING_ADDRESS")
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String streetNr;
    private String addition;
    private String plz;
    private String locus;
    private String country;

    @OneToOne(mappedBy = "billingAddress")
    private AppUser appUser;

    public BillingAddress(String street,
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getLocus() {
        return locus;
    }

    public void setLocus(String locus) {
        this.locus = locus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
