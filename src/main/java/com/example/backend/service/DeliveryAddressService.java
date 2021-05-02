package com.example.backend.service;

import com.example.backend.entity.DeliveryAddress;
import com.example.backend.repository.DeliveryAddressRepository;
import com.example.backend.request.DeliveryAddressRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    public String create(DeliveryAddress deliveryAddress) {

        try {
            deliveryAddressRepository.save(deliveryAddress);
            return "created succeed";
        } catch (Exception e) {
            return "create failed";
        }
        //TODO send conformation token
    }

    public String getById(Long id) {
        Optional<DeliveryAddress> deliveryAddressData = deliveryAddressRepository.findById(id);
        if (deliveryAddressData.isPresent()) {
            return deliveryAddressData.get().getStreet();
        } else return "get failed";
    }

    public String deleteById(Long id) {
        try {
            deliveryAddressRepository.deleteById(id);
            return "delete okay";
        } catch (Exception e) {
            return "delete failed";
        }
    }

    public String putById(Long id, DeliveryAddressRequest request) {
        Optional<DeliveryAddress> deliveryAddressData = deliveryAddressRepository.findById(id);

        if (deliveryAddressData.isPresent()) {
            DeliveryAddress deliveryAddress = deliveryAddressData.get();
            deliveryAddress.setStreet(request.getStreet());
            deliveryAddress.setStreetNr(request.getStreetNr());
            deliveryAddress.setAddition(request.getAddition());
            deliveryAddress.setLocus(request.getLocus());
            deliveryAddress.setPlz(request.getPlz());
            deliveryAddress.setCountry(request.getCountry());
            deliveryAddressRepository.save(deliveryAddress);
            return "put okay";
        } else {
            return "put failed";
        }
    }
}
