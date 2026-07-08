package com.AmanaCover.dto;

import com.AmanaCover.enums.PolicyStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyRequestDTO {

    @NotBlank(message="Policy number is required")
    private String policyNumber;

    @NotBlank(message="insured name is required")
    private String insuredName;

    @NotNull(message="Premium is required")
    @DecimalMin("0.0")
    private BigDecimal premium;

    @NotNull(message="Status is required")
    private PolicyStatus status;
}
