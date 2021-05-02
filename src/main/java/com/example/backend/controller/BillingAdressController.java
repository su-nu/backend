package com.example.backend.controller;


import com.example.backend.entity.BillingAdress;
import com.example.backend.request.BillingAdressRequest;
import com.example.backend.service.BillingAdressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(path = "api/billingadress")
@AllArgsConstructor
public class BillingAdressController {

    private BillingAdressService billingAdressService;

    @PostMapping("/create")
    public String create(@RequestBody BillingAdressRequest request) {


        return billingAdressService.create(new BillingAdress(
                request.getStreet(),
                request.getStreetNr(),
                request.getAddition(),
                request.getPlz(),
                request.getCountry(),
                request.getCountry()
        ));
    }

    @GetMapping("/get/{id}")
    public String getById (@PathVariable ("id") Long id) {
         return billingAdressService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return billingAdressService.deleteById(id);
    }

    @PutMapping("put/{id}")
    public String putByid(@PathVariable ("id") Long id, @RequestBody BillingAdressRequest request) {
        return billingAdressService.putByid(id, request);
    }
}
