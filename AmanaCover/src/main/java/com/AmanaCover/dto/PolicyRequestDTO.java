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

    @NotBlank
    private String policyNumber;

    @NotBlank
    private String insuredName;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal premium;

    @NotNull
    private PolicyStatus status;
}
