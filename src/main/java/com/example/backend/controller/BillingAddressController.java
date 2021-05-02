package com.example.backend.controller;


import com.example.backend.entity.BillingAdress;
import com.example.backend.request.BillingAdressRequest;
import com.example.backend.service.BillingAddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/billingaddress")
@AllArgsConstructor
public class BillingAddressController {

    private final BillingAddressService billingAddressService;

    @PostMapping("/create")
    public String create(@RequestBody BillingAdressRequest request) {


        return billingAddressService.create(new BillingAdress(
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
         return billingAddressService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return billingAddressService.deleteById(id);
    }

    @PutMapping("put/{id}")
    public String putById(@PathVariable ("id") Long id, @RequestBody BillingAdressRequest request) {
        return billingAddressService.putById(id, request);
    }
}
