package com.example.backend.service;


import com.example.backend.appUser.AppUser;
import com.example.backend.entity.BillingAdress;
import com.example.backend.repository.BillingAdressRepository;
import com.example.backend.request.BillingAdressRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BillingAdressService {

    private BillingAdressRepository billingAdressRepository;

    public String create(BillingAdress billingAdress) {

        billingAdressRepository.save(billingAdress);
        //TODO send conformation token
        return "it works";
    }
}
