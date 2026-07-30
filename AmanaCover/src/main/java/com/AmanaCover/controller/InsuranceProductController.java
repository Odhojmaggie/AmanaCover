package com.AmanaCover.controller;

import com.AmanaCover.dto.ProductRequestDTO;
import com.AmanaCover.dto.ProductResponseDTO;
import com.AmanaCover.service.InsuranceProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class InsuranceProductController {

    private final InsuranceProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductRequestDTO request
    ) {

        return ResponseEntity.ok(
                service.createProduct(request)
        );
    }
}