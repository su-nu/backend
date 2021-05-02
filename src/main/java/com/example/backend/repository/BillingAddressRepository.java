package com.example.backend.repository;


import com.example.backend.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional( readOnly = true)
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

}
