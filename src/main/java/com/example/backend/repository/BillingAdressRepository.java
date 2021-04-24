package com.example.backend.repository;


import com.example.backend.entity.BillingAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional( readOnly = true)
public interface BillingAdressRepository extends JpaRepository<BillingAdress, Long> {

}
