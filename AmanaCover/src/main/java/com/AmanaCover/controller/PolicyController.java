package com.AmanaCover.controller;

import com.AmanaCover.dto.PolicyRequestDTO;
import com.AmanaCover.dto.PolicyResponseDTO;
import com.AmanaCover.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PolicyResponseDTO>> getPolicies() {
        return ResponseEntity.ok(service.getAllPolicies());
    }
}
