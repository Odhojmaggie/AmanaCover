package com.AmanaCover.dto;

import com.AmanaCover.enums.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDTO {

    private Long id;

    private String productName;

    private ProductCategory category;

    private BigDecimal basePremiumRate;

    private String description;
}