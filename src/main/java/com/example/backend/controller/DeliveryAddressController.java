package com.example.backend.controller;

import com.example.backend.entity.BillingAddress;
import com.example.backend.entity.DeliveryAddress;
import com.example.backend.request.BillingAddressRequest;
import com.example.backend.request.DeliveryAddressRequest;
import com.example.backend.service.BillingAddressService;
import com.example.backend.service.DeliveryAddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/deliveryaddress")
@AllArgsConstructor
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    @PostMapping("/create")
    public String create(@RequestBody DeliveryAddressRequest request) {

        return deliveryAddressService.create(new DeliveryAddress(
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
        return deliveryAddressService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return deliveryAddressService.deleteById(id);
    }

    @PutMapping("update/{id}")
    public String putByid(@PathVariable ("id") Long id, @RequestBody DeliveryAddressRequest request) {
        return deliveryAddressService.putById(id, request);
    }
}
