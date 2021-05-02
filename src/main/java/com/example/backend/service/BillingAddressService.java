package com.example.backend.service;

import com.example.backend.entity.BillingAddress;
import com.example.backend.repository.BillingAddressRepository;
import com.example.backend.request.BillingAddressRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BillingAddressService {

    private final BillingAddressRepository billingAddressRepository;

    public String create(BillingAddress billingAddressesRequest) {

        try {
            billingAddressRepository.save(billingAddressesRequest);
            return "created succeed";
        } catch (Exception e) {
            return "create failed";
        }
        //TODO send conformation token
    }

    public String getById(Long id) {
        Optional<BillingAddress> billingAddressesData = billingAddressRepository.findById(id);
        if (billingAddressesData.isPresent()) {
            return billingAddressesData.get().getStreet();
        } else return "get failed";
    }

    public String deleteById(Long id) {
        try {
            billingAddressRepository.deleteById(id);
            return "delete okay";
        } catch (Exception e) {
            return "delete failed";
        }
    }

    public String putById(Long id, BillingAddressRequest request) {
        Optional<BillingAddress> billingAddressData = billingAddressRepository.findById(id);

        if (billingAddressData.isPresent()) {
            BillingAddress billingAddress = billingAddressData.get();
            billingAddress.setStreet(request.getStreet());
            billingAddress.setStreetNr(request.getStreetNr());
            billingAddress.setAddition(request.getAddition());
            billingAddress.setLocus(request.getLocus());
            billingAddress.setPlz(request.getPlz());
            billingAddress.setCountry(request.getCountry());
            billingAddressRepository.save(billingAddress);
            return "put okay";
        } else {
            return "put failed";
        }
    }
}
