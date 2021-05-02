package com.example.backend.request;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DeliveryAddressRequest {

    private String street;
    private String streetNr;
    private String addition;
    private String plz;
    private String locus;
    private String country;

}
