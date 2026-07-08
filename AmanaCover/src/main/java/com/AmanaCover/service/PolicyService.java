package com.AmanaCover.service;

import com.AmanaCover.enums.PolicyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.AmanaCover.exception.ResourceNotFoundException;
import com.AmanaCover.dto.PolicyRequestDTO;
import com.AmanaCover.dto.PolicyResponseDTO;
import com.AmanaCover.entity.Policy;
import com.AmanaCover.repository.PolicyRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@Transactional
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
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO request) {

        log.info("Updating policy with id: {}", id);

        Policy policy = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Policy not found with id: " + id
                ));

        // Update fields
        policy.setPolicyNumber(request.getPolicyNumber());
        policy.setInsuredName(request.getInsuredName());
        policy.setPremium(request.getPremium());
        policy.setStatus(request.getStatus());

        Policy updated = repository.save(policy);

        return mapToResponse(updated);
    }
    public void deletePolicy(Long id) {

        log.info("Deleting policy with id: {}", id);

        Policy policy = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Policy not found with id: " + id
                ));

        repository.delete(policy);
    }
    public PolicyResponseDTO getPolicyById(Long id) {

        log.info("Fetching policy with id: {}", id);

        Policy policy = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Policy not found with id: " + id
                ));

        return mapToResponse(policy);
    }
    public PolicyResponseDTO getByPolicyNumber(String policyNumber) {
        Policy policy = repository.findByPolicyNumber(policyNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        return mapToResponse(policy);
    }
    public List<PolicyResponseDTO> getAllPolicies(int page, int size) {

        Page<Policy> policyPage =
                repository.findAll(PageRequest.of(page, size));

        return policyPage.getContent()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public List<PolicyResponseDTO> getPoliciesByStatus(PolicyStatus status) {

        return repository.findByStatus(status)
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
