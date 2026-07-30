package com.AmanaCover.dto;

import com.AmanaCover.enums.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    private String productName;

    private ProductCategory category;

    private BigDecimal basePremiumRate;

    private String description;
}