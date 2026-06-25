package com.AmanaCover.dto;

import com.AmanaCover.enums.PolicyStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponseDTO {

    private Long id;
    private String policyNumber;
    private String insuredName;
    private BigDecimal premium;
    private PolicyStatus status;
    private LocalDateTime createdAt;
}
