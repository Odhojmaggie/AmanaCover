package com.AmanaCover.repository;

import com.AmanaCover.enums.PolicyStatus;
import com.AmanaCover.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    Optional<Policy> findByPolicyNumber(String policyNumber);

    List<Policy> findByStatus(PolicyStatus status);
}