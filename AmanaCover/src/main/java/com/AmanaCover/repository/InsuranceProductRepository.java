package com.AmanaCover.repository;

import com.AmanaCover.entity.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceProductRepository
        extends JpaRepository<InsuranceProduct, Long> {
}