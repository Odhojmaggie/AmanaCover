package com.AmanaCover.controller;

import com.AmanaCover.enums.PolicyStatus;
import java.util.List;
import com.AmanaCover.dto.PolicyRequestDTO;
import com.AmanaCover.dto.PolicyResponseDTO;
import com.AmanaCover.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/policies")

public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> createPolicy(
            @Valid @RequestBody PolicyRequestDTO request
    ) {
        return ResponseEntity.ok(service.createPolicy(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> updatePolicy(
            @PathVariable Long id,
            @Valid @RequestBody PolicyRequestDTO request
    ) {
        return ResponseEntity.ok(service.updatePolicy(id, request));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id) {

        return ResponseEntity.ok(service.getPolicyById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<PolicyResponseDTO> getByPolicyNumber(
            @RequestParam String policyNumber
    ) {
        return ResponseEntity.ok(service.getByPolicyNumber(policyNumber));
    }
    @GetMapping
    public ResponseEntity<List<PolicyResponseDTO>> getAllPolicies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        return ResponseEntity.ok(
                service.getAllPolicies(page, size)
        );
    }
    @GetMapping("/filter")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByStatus(
            @RequestParam PolicyStatus status
    ) {
        return ResponseEntity.ok(
                service.getPoliciesByStatus(status)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {

        service.deletePolicy(id);

        return ResponseEntity.noContent().build();
    }
}


