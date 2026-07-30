package com.AmanaCover.service;

import com.AmanaCover.dto.ProductRequestDTO;
import com.AmanaCover.dto.ProductResponseDTO;
import com.AmanaCover.entity.InsuranceProduct;
import com.AmanaCover.repository.InsuranceProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceProductService {

    private final InsuranceProductRepository repository;

    public ProductResponseDTO createProduct(
            ProductRequestDTO request
    ) {

        InsuranceProduct product =
                InsuranceProduct.builder()
                        .productName(request.getProductName())
                        .category(request.getCategory())
                        .basePremiumRate(
                                request.getBasePremiumRate()
                        )
                        .description(request.getDescription())
                        .build();

        product = repository.save(product);

        return ProductResponseDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .category(product.getCategory())
                .basePremiumRate(
                        product.getBasePremiumRate()
                )
                .description(product.getDescription())
                .build();
    }
}