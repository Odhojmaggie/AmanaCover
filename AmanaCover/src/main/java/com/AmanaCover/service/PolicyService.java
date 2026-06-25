package com.AmanaCover.service;

import com.AmanaCover.dto.PolicyRequestDTO;
import com.AmanaCover.dto.PolicyResponseDTO;
import com.AmanaCover.entity.Policy;
import com.AmanaCover.repository.PolicyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PolicyService {

    private final PolicyRepository repository;

    public PolicyService(PolicyRepository repository) {
        this.repository = repository;
    }

    public PolicyResponseDTO createPolicy(PolicyRequestDTO request) {

        log.info("Creating policy: {}", request.getPolicyNumber());

        Policy policy = Policy.builder()
                .policyNumber(request.getPolicyNumber())
                .insuredName(request.getInsuredName())
                .premium(request.getPremium())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .build();

        Policy saved = repository.save(policy);

        return mapToResponse(saved);
    }

    public List<PolicyResponseDTO> getAllPolicies() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private PolicyResponseDTO mapToResponse(Policy policy) {
        return PolicyResponseDTO.builder()
                .id(policy.getId())
                .policyNumber(policy.getPolicyNumber())
                .insuredName(policy.getInsuredName())
                .premium(policy.getPremium())
                .status(policy.getStatus())
                .createdAt(policy.getCreatedAt())
                .build();
    }
}
