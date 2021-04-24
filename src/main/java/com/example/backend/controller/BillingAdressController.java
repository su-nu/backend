package com.example.backend.controller;


import com.example.backend.entity.BillingAdress;
import com.example.backend.registration.RegistrationRequest;
import com.example.backend.request.BillingAdressRequest;
import com.example.backend.service.BillingAdressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(path = "api/billingadress/create")
@AllArgsConstructor
public class BillingAdressController {

    private BillingAdressService billingAdressService;

    @PostMapping
    public String register(@RequestBody BillingAdressRequest request) {


        return billingAdressService.create(new BillingAdress(
                request.getStreet(),
                request.getStreetNr(),
                request.getAddition(),
                request.getPlz(),
                request.getCountry(),
                request.getCountry()
        ));
    }
}
