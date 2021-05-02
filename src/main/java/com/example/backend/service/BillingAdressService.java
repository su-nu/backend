package com.example.backend.service;

import com.example.backend.entity.BillingAdress;
import com.example.backend.repository.BillingAdressRepository;
import com.example.backend.request.BillingAdressRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BillingAdressService {

    private final BillingAdressRepository billingAdressRepository;

    public String create(BillingAdress billingAdressRequest) {

        try {
            BillingAdress billingAdress = billingAdressRepository.save(billingAdressRequest);
            return "created succeed";
        } catch (Exception e) {
            return "create failed";
        }
        //TODO send conformation token
    }

    public String getById(Long id) {
        Optional<BillingAdress> billingAdressData = billingAdressRepository.findById(id);
        if(billingAdressData.isPresent()){
            return billingAdressData.get().getStreet();
        }
        else return "get failed";
    }

    public String deleteById(Long id) {
        try{
            billingAdressRepository.deleteById(id);
            return "delete okay";
        }
        catch (Exception e) {
            return "delete failed";
        }
    }

    public String putByid(Long id, BillingAdressRequest request) {
       Optional<BillingAdress> billingAdressData = billingAdressRepository.findById(id);

        if(billingAdressData.isPresent()){
            BillingAdress billingAdress = billingAdressData.get();
            billingAdress.setStreet(request.getStreet());
            billingAdress.setStreetNr(request.getStreetNr());
            billingAdress.setAddition(request.getAddition());
            billingAdress.setLocus(request.getLocus());
            billingAdress.setPlz(request.getPlz());
            billingAdress.setCountry(request.getCountry());
            billingAdressRepository.save(billingAdress);
            return "put okay";
        }else {
            return "put failed";
        }
    }
}
