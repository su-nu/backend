package com.example.backend.repository;

import com.example.backend.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional()
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {
}
